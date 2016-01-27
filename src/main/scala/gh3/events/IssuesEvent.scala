package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3Issue}
import net.liftweb.json.JsonAST.JValue

case class IssuesEvent(
                         action: String,
                         issue: GH3Issue,
                         repository: GH3Repository,
                         sender: GH3Sender
                      ) extends GH3Event

object IssuesEvent
{
   def apply(json: JValue): Option[IssuesEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val issue = GH3Issue(json \ "issue")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, issue, repository, sender).forall(_.isDefined))
         Some(new IssuesEvent(action.get, issue.get, repository.get, sender.get))
      else None
   }
}