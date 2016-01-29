package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class PublicEventPayload(repo: String, actor: String, actor_gravatar: String)

object PublicEventPayload
{
   def apply(json: JValue): Option[PublicEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2l = gh3.node2Long(json)(_)

      val repo = n2s("repo")
      val actor = n2s("actor")
      val actor_gravatar = n2s("actor_gravatar")

      val params = Seq(repo, actor, actor_gravatar)

      if(params.forall(_.isDefined))
         Some(PublicEventPayload(repo.get, actor.get, actor_gravatar.get))
      else None
   }
}

