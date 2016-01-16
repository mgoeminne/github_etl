package gh3

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime


case class GH3DeploymentStatus(
                           url: String,
                           id: Long,
                           state: String,
                           creator: GH3Sender,
                           description: Option[String],
                           target_url: Option[String],
                           created_at: LocalDateTime,
                           updated_at: LocalDateTime,
                           deployment_url: String,
                           repository_url: String
                           )

object GH3DeploymentStatus
{
   def apply(json: JValue): Option[GH3DeploymentStatus] =
   {
      val n2s = node2String(json)(_)
      
      val url = n2s("url")
      val id = node2Long(json)("id")
      val state = n2s("state")
      val creator = GH3Sender(json \ "creator")
      val description = node2OptionString(json)("description")
      val target_url = node2OptionString(json)("target_url")
      val created_at = node2LocalDateTime(json)("created_at")
      val updated_at = node2LocalDateTime(json)("updated_at")
      val deployment_url = n2s("deployment_url")
      val repository_url = n2s("repository_url")

      val params = Seq(url, id, state, creator, description, target_url, created_at, updated_at, deployment_url, repository_url)

      if(params.forall(_.isDefined))
         Some(new GH3DeploymentStatus( url.get, id.get, state.get, creator.get, description.get, target_url.get,
                                       created_at.get, updated_at.get, deployment_url.get, repository_url.get))
      else None
   }
}
