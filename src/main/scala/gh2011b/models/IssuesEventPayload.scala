package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class IssuesEventPayload(number: Long, repo: String, actor: String, issue: Long,
                              actor_gravatar: String, action: String)

object IssuesEventPayload
{
   def apply(json: JValue): Option[IssuesEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val number = n2l("number")
      val repo = n2s("repo")
      val actor = n2s("actor")
      val issue = n2l("issue")
      val actor_gravatar = n2s("actor_gravatar")
      val action = n2s("action")

      val params = Seq(number, repo, actor, issue, actor_gravatar, action)

      if(params.forall(_.isDefined))
         Some(IssuesEventPayload(number.get, repo.get, actor.get, issue.get, actor_gravatar.get, action.get))
      else None
   }
}
