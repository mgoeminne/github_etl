package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3PullRequestForReviewComment}
import net.liftweb.json.JsonAST.JValue

case class PullRequestEvent(
                              action: String,
                              number: Long,
                              pull_request: GH3PullRequestForReviewComment,
                              repository: GH3Repository,
                              sender: GH3Sender
                           ) extends GH3Event

object PullRequestEvent extends GH3EventParser
{
   def apply(json: JValue): Option[PullRequestEvent] =
   {
      val action = node2String(json)("action")
      val number = node2Long(json)("number")
      val pull_request = GH3PullRequestForReviewComment(json \ "pull_request")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, number, pull_request, repository, sender).forall(_.isDefined))
         Some(new PullRequestEvent(action.get, number.get, pull_request.get, repository.get, sender.get))
      else None
   }
}