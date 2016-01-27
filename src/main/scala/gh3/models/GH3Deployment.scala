package gh3.models

import gh3._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class GH3Deployment(
                           url: String,
                           id: Long,
                           sha: String,
                           ref: String,
                           task: String,
                           environment: String,
                           description: Option[String],
                           creator: GH3Sender,
                           created_at: LocalDateTime,
                           updated_at: LocalDateTime,
                           statuses_url: String,
                           repository_url: String

                        )

object GH3Deployment
{
   def apply(json: JValue): Option[GH3Deployment] =
   {
      val n2s = node2String(json)(_)
      
      val url = n2s("url")
      val id = node2Long(json)("id")
      val sha = n2s("sha")
      val ref = n2s("ref")
      val task = n2s("task")
      val environment = n2s("environment")
      val description = node2OptionString(json)("description")
      val creator = GH3Sender(json \ "creator")
      val created_at = node2LocalDateTime(json)("created_at")
      val updated_at = node2LocalDateTime(json)("updated_at")
      val statuses_url = n2s("statuses_url")
      val repository_url = n2s("repository_url")

      val params = Seq(url, id, sha, ref, task, environment, description, creator, created_at, updated_at, statuses_url, repository_url)

      if(params.forall(_.isDefined))
         Some(new GH3Deployment( url.get, id.get, sha.get, ref.get, task.get, environment.get, description.get,
                                 creator.get, created_at.get, updated_at.get, statuses_url.get, repository_url.get))
      else None
   }
}

