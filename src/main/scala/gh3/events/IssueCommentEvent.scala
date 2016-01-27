package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3IssueComment, GH3Issue}
import net.liftweb.json.JsonAST.JValue

case class IssueCommentEvent(action: String,
                             issue: GH3Issue,
                             comment: GH3IssueComment,
                             repository: GH3Repository,
                             sender: GH3Sender
                            ) extends GH3Event

object IssueCommentEvent
{
   def apply(json: JValue): Option[IssueCommentEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val issue = GH3Issue(json \ "issue")
      val comment = GH3IssueComment(json \ "comment")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(action, issue, comment, repository, sender)

      if(params.forall(_.isDefined))
         Some(new IssueCommentEvent(action.get, issue.get, comment.get, repository.get, sender.get))
      else None
   }
}