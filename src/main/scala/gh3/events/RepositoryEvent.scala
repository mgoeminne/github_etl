package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3Organization}
import net.liftweb.json.JsonAST.JValue

case class RepositoryEvent(
                             action: String,
                             repository: GH3Repository,
                             organization: GH3Organization,
                             sender: GH3Sender
                          ) extends GH3Event



object RepositoryEvent extends GH3EventParser
{
   def apply(json: JValue): Option[RepositoryEvent] =
   {
      val action = node2String(json)("action")
      val repository = GH3Repository(json \ "repository")
      val organization = GH3Organization(json \ "organization")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(action, repository, organization, sender)

      if(params.forall(_.isDefined))
         Some(new RepositoryEvent(action.get, repository.get, organization.get, sender.get))
      else None
   }
}
