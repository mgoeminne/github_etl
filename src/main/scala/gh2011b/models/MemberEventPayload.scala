package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class MemberEventPayload(repo: String, member: String, actor: String, actor_gravatar: String, action: String)

object MemberEventPayload
{
   def apply(json: JValue): Option[MemberEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val repo = n2s("repo")
      val member = n2s("member")
      val actor = n2s("actor")
      val actor_gravatar = n2s("actor_gravatar")
      val action = n2s("action")

      val params = Seq(repo, member, actor, actor, actor_gravatar, action)

      if(params.forall(_.isDefined))
         Some(MemberEventPayload(repo.get, member.get, actor.get, actor_gravatar.get, action.get))
      else None
   }
}

