package gh3.events

import gh3.{GH3Sender, GH3Repository, GH3Deployment}
import net.liftweb.json.JsonAST.JValue

case class DeploymentEvent(
                             deployment: GH3Deployment,
                             repository: GH3Repository,
                             sender: GH3Sender
                          ) extends GH3Event

object DeploymentEvent
{
   def apply(json: JValue): Option[DeploymentEvent] =
   {
      val deployment = GH3Deployment(json \ "deployment")
      val repository = GH3Repository(json \ "repository")
      val sender     = GH3Sender(json \ "sender")

      if(Seq(deployment, repository, sender).forall(_.isDefined))
         Some(new DeploymentEvent(deployment.get, repository.get, sender.get))
      else None
   }
}
