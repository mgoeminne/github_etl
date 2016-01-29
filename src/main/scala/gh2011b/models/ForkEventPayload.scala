package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class ForkEventPayload(repo: String, actor: String, forkee: Long, actor_gravatar: String)

object ForkEventPayload
{
   def apply(json: JValue): Option[ForkEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2l = gh3.node2Long(json)(_)

      val repo = n2s("repo")
      val actor = n2s("actor")
      val forkee = n2l("forkee")
      val actor_gravatar = n2s("actor_gravatar")

      val params = Seq(repo, actor, forkee, actor_gravatar)

      if(params.forall(_.isDefined))
         Some(ForkEventPayload(repo.get, actor.get, forkee.get, actor_gravatar.get))
      else None
   }
}

