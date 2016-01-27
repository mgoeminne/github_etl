package gh3.events

import gh3._
import net.liftweb.json.JsonAST.JValue

case class PullRequestReviewCommentEvent(
                                           action: String,
                                           comment: GH3PullRequestComment,
                                           pull_request: GH3PullRequest,
                                           repository: GH3Repository,
                                           sender: GH3Sender
                                        ) extends GH3Event

object PullRequestReviewCommentEvent
{
   def apply(json: JValue): Option[PullRequestReviewCommentEvent] =
   {
      val action = node2String(json)("action")
      val comment = GH3PullRequestComment(json \ "comment")
      val pull_request = GH3PullRequest(json \ "pull_request")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      println(Seq(action, comment, pull_request, repository, sender).map(_.isDefined))

      if(Seq(action, comment, pull_request, repository, sender).forall(_.isDefined))
         Some(new PullRequestReviewCommentEvent(action.get, comment.get, pull_request.get, repository.get, sender.get))
      else None
   }
}