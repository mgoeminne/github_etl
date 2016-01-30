package gh2013.payloads

import gh2013.models.PullRequest
import net.liftweb.json.JsonAST.JValue

case class PullRequestEventPayload(number: Long, action: String, pull_request: PullRequest)

object PullRequestEventPayload
{
   def apply(json: JValue): Option[PullRequestEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val number = n2l("number")
      val action = n2s("action")
      val pull_request = PullRequest(json \ "pull_request")

      val params = Seq(number, action, pull_request)

      println(params.map(_.isDefined))

      if(params.forall(_.isDefined)) Some(PullRequestEventPayload(number.get, action.get, pull_request.get))
      else None
   }
}

