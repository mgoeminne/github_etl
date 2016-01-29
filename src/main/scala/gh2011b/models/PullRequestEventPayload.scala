package gh2011b.models

import gh2011.models.PullRequest
import net.liftweb.json.JsonAST.JValue


case class PullRequestEventPayload(number: Long, pull_request: PullRequest, action: String)

object PullRequestEventPayload
{
   def apply(json: JValue): Option[PullRequestEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val number = n2l("number")
      val pull_request = PullRequest(json \ "pull_request")
      val action = n2s("action")

      val params = Seq(number, pull_request, action)

      if(params.forall(_.isDefined))
         Some(PullRequestEventPayload(number.get, pull_request.get, action.get))
      else None
   }
}
