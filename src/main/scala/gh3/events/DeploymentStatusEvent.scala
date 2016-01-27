package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3DeploymentStatus, GH3Deployment}
import net.liftweb.json.JsonAST.JValue

case class DeploymentStatusEvent(
                                   deployment: GH3Deployment,
                                   deployment_status: GH3DeploymentStatus,
                                   repository: GH3Repository,
                                   sender: GH3Sender
                                ) extends GH3Event

object DeploymentStatusEvent extends GH3EventParser
{
   def apply(json: JValue): Option[DeploymentStatusEvent] =
   {
      val deployment = GH3Deployment(json \ "deployment")
      val deployment_status = GH3DeploymentStatus(json \ "deployment_status")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(deployment, deployment_status, repository, sender)

      if(params.forall(_.isDefined))
         Some(new DeploymentStatusEvent(deployment.get, deployment_status.get, repository.get, sender.get))
      else None
   }
}