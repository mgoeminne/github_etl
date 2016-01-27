package gh3.events

import gh3.{GH3Sender, GH3Repository, GH3CommitComment}
import net.liftweb.json.JsonAST.JValue

case class CommitCommentEvent(
                                action: String,
                                comment: GH3CommitComment,
                                repository: GH3Repository,
                                sender: GH3Sender
                             ) extends GH3Event

object CommitCommentEvent
{
   def apply(json: JValue): Option[CommitCommentEvent] =
   {
      val n2s = gh3.node2String(json)(_)

      val action = n2s("action")
      val comment = GH3CommitComment(json \ "comment")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if (Seq(action, comment, repository, sender).forall(_.isDefined))
         Some(new CommitCommentEvent(action.get, comment.get, repository.get, sender.get))
      else None
   }
}
