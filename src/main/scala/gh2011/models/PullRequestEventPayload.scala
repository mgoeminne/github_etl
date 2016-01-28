package gh2011.models

import net.liftweb.json.JsonAST.JValue


case class PullRequestEventPayload(number: Long, pull_request: PullRequest, repo: String, actor: String,
                                   actor_gravatar: String, action: String)

object PullRequestEventPayload
{
   def apply(json: JValue): Option[PullRequestEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val number = n2l("number")
      val pull_request = PullRequest(json \ "pull_request")
      val repo = n2s("repo")
      val actor = n2s("actor")
      val actor_gravatar = n2s("actor_gravatar")
      val action = n2s("action")

      val params = Seq(number, pull_request, repo, actor, actor_gravatar, action)

      if(params.forall(_.isDefined))
         Some(PullRequestEventPayload(number.get, pull_request.get, repo.get, actor.get, actor_gravatar.get, action.get))
      else None
   }
}
