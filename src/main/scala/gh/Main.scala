package gh

import java.io._
import java.util.zip.GZIPInputStream

import com.typesafe.scalalogging.Logger
import net.liftweb.json.JsonAST.JValue
import net.liftweb.json._
import org.joda.time.format.DateTimeFormat
import org.slf4j.LoggerFactory
import scalikejdbc._

/**
  * Created by mg on 12/01/16.
  */
object Main
{
   Class.forName("com.mysql.jdbc.Driver")
   ConnectionPool.singleton("jdbc:mysql://localhost:8889/github", "root", "root")

   implicit val session = AutoSession

   val directory = new File("/Users/mg/Downloads/gharchive")
   val logger = Logger(LoggerFactory.getLogger("log"))
   val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

   def main(args: Array[String])
   {

      val files = directory.listFiles().filter(f => f.getName endsWith ".json.gz")
                                       .filter(f => f.getName startsWith "2011")
                                       .take(100)

      val recorded_projects = scala.collection.mutable.Set[Long]()
      val recorded_contributors = scala.collection.mutable.Set[String]()

      files.foreach(file => {
         logger.debug("Reading file " + file)

         val gzipStream = new GZIPInputStream(new FileInputStream(file))
         val decoder = new InputStreamReader(gzipStream, "UTF-8")
         val buffered = new BufferedReader(decoder)

         buffered.lines.toArray.foreach(line => {
            val json = parse(line.toString)


            json match {
               case x: JObject => gh2011.parse(x) match {
                  case Some(a) => //println(a)
                  case _ => println("NOT PARSED: " + line)
               }
               case _ => "ERROR " + json
            }

            //logger.info("Parse line " + line)


            /*

            json match {
               case document :JObject => {
                  val repo = (json \ "repository")
                  val url = (repo \ "url")      match { case JString(x) => x }
                  val `type` = (json \ "type")  match { case JString(x) => x }
                  val date = (json \ "created_at") match { case JString (d) => formatter.parseLocalDateTime(d.take(19)) }

                  val repository = (repo \ "id") match {
                     case JInt(x) => x.toLong
                  }

                  if(!(recorded_projects contains repository)){
                     val id = (repo \ "id") match {
                        case JInt(x) => x.toLong
                     }

                     val owner = (repo \ "owner") match { case JString(x) => x }

                     val name = (repo \ "name") match {
                        case JString(x) => x
                     }

                     val domain = null
                     val licence = null
                     val organization = (repo \ "organization") match {
                        case JString(x) => x
                        case _ => null
                     }

                     val stargazers = (repo \ "stargazers_count") match {
                        case JInt(x) => x
                        case _ => (repo \ "stargazers") match {
                           case JInt(x) => x
                        }
                     }

                     val watchers = (repo \ "watchers_count") match {
                        case JInt(x) => x
                        case _ => (repo \ "watchers") match {
                           case JInt(x) => x
                        }
                     }

                     val is_fork = (repo \ "fork") match {
                        case JBool(x) => x
                        case _ => false
                     }

                     sql"""
                          INSERT INTO project
                          (id, url, owner, name, domain, licence, umbrella_project, first_activity, last_activity, deleted, is_fork, max_stagazers, max_watchers)
                          VALUES (${id}, ${url}, ${owner}, ${name}, ${domain}, ${licence}, ${organization}, ${date}, ${date}, 0, ${is_fork}, ${stargazers}, ${watchers})
                        """.update()

                     recorded_projects.add(id)
                  }

                  // https://developer.github.com/v3/activity/events/types/
                  `type` match {
                     case "PushEvent" =>
                     {
                        val sender_login = (json \ "sender" \ "login")

                        val push_id = sql"""
                              INSERT INTO push
                              (date, sender_login)
                              VALUES(${date}, ${sender_login})
                           """.updateAndReturnGeneratedKey("id")


                        (json \ "commits") match {
                           case JArray(commits) => {
                              val formatted_commits = commits.map(commit => {
                                 val hash = (commit \ "id") match {
                                    case JString(x) => x
                                 }

                                 val author_login = (commit \ "author" \ "username") match {
                                    case JString(x) => x
                                 }

                                 if(!(recorded_contributors contains author_login)){
                                    val author = (commit \ "author")
                                    val name = (author \ "name") match { case JString(x) => x }
                                    val email = (author \ "email") match { case JString(x) => x }

                                    sql"""
                                          INSERT INTO contributor
                                          (login, name, mail)
                                          VALUES(${author_login}, ${name}, ${email})
                                       """.update()
                                    recorded_contributors.add(author_login)
                                 }

                                 val commit_date = (commit \ "timestamp") match { case JString(x) => formatter.parseLocalDateTime(x.take(19)) }

                                 val added = (commit \ "added") match {
                                    case JArray(list) => list.map(a => a match { case JString(x) => x})
                                 }

                                 val removed = (commit \ "removed") match {
                                    case JArray(list) => list.map(a => a match { case JString(x) => x})
                                 }

                                 val modified = (commit \ "modified") match {
                                    case JArray(list) => list.map(a => a match { case JString(x) => x})
                                 }

                                 (hash, commit_date, author_login, added, removed, modified)
                              })

                              formatted_commits.foreach(commit => {
                                 sql"""
                                       INSERT INTO commit
                                       (id, push_id, project_id, date, author_id)
                                       VALUES(UNHEX(${commit._1}), ${push_id}, ${repository}, ${commit._2}, ${commit._3})
                                    """.update()

                                 val add_batch = commit._4.map(Seq(commit._1, _, "add"))

                                 sql"""
                                       INSERT INTO changes
                                       (commit_id, filename, action)
                                       VALUES(?,?,?)
                                    """.batch(add_batch)
                                       .apply()

                                 val delete_batch = commit._5.map(Seq(commit._1, _, "delete"))

                                 sql"""
                                       INSERT INTO changes
                                       (commit_id, filename, action)
                                       VALUES(?,?,?)
                                    """.batch(delete_batch)
                                    .apply()

                                 val modify_batch = commit._6.map(Seq(commit._1, _, "modify"))

                                 sql"""
                                       INSERT INTO changes
                                       (commit_id, filename, action)
                                       VALUES(?,?,?)
                                    """.batch(modify_batch)
                                    .apply()
                              })
                           }
                        }



                     }

                     case "CreateEvent" =>
                     {
                        // If ref_type (in the payload) equals "repository", then a new repository is created
                        // This situation is already handled in the code above

                        val ref_type = (repo \ "ref_type") match {

                           // If ref_type (in the payload) equals "branch", then a new branch is created
                           case JString("branch") => {
                               sql"""
                                     UPDATE project
                                     SET branches = branches + 1
                                     WHERE id = ${repository}
                                  """.update()
                           }
                        }

                     }

                     case "DeleteEvent" =>
                     {
                        sql"""
                           UPDATE project
                           SET last_activity=${date}, deleted=1
                           WHERE id=${repository}
                           """.update()
                     }

                     case "FollowEvent" =>
                     {
                        // A user follows an other user (no longer in use)
                     }



                     case "PublicEvent" =>
                     {
                        // The repository was private, but is now public
                        sql"""
                              UPDATE project
                              SET was_private = 1
                              WHERE id = ${repository}
                           """.update()
                     }

                     case "IssuesEvent" =>
                     {
                        // An issue has been created, modified, assigned, etc.
                        // action: "assigned", "unassigned", "labeled", "unlabeled", "opened", "closed", or "reopened"
                     }

                     case "ForkEvent" =>
                     {
                        sql"""
                              UPDATE project
                              SET fork = fork+1
                              WHERE id = ${repository}
                           """.update
                     }

                     case "PullRequestEvent" =>
                     {
                        // A pull request is created, modified, assigned, etc.
                        // action: "assigned", "unassigned", "labeled", "unlabeled", "opened", "closed", or "reopened", or "synchronize"
                     }

                     case "RepositoryEvent" =>
                     {
                        // The only available action is "created" to specify the repository has been created
                        // This situation is already handled in the code above
                     }

                     case "WatchEvent" =>
                     {
                        // A user started to stare (and not watch) a repository
                     }

                     case _ =>
                     {
                        //println (typ)
                     }
                  }
               }

               case _ => logger.error("Unable to parse : " + line)
            }

            */
         })

         buffered.close()
      })
   }
}
