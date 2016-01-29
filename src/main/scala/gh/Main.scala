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

      val recorded_projects = scala.collection.mutable.Set[Long]()
      val recorded_contributors = scala.collection.mutable.Set[String]()

      var read_lines = 0L
      var valid_lines = 0L
      var parsed_lines = 0L

      files.foreach(file => {
         logger.debug("Reading file " + file)

         val gzipStream = new GZIPInputStream(new FileInputStream(file))
         val decoder = new InputStreamReader(gzipStream, "UTF-8")
         val buffered = new BufferedReader(decoder)
         val lines = buffered.lines.toArray

         read_lines += lines.size

         lines.foreach(line => {

            val json = parse(line.toString)

            valid_lines += 1

            json match {
               case x: JObject => gh2011.parse(x) match {
                  case Some(a) => parsed_lines += 1
                  case _ => println("NOT PARSED: " + line)
               }
               case _ => "ERROR " + json
            }

            //logger.info("Parse line " + line)

         })

         buffered.close()

         println(read_lines + " \t" + valid_lines + " (" + (valid_lines / read_lines.toFloat).formatted("%03f") + ") \t" + parsed_lines + " (" + (parsed_lines / valid_lines.toFloat).formatted("%03f") + ")")
      })
   }
}
