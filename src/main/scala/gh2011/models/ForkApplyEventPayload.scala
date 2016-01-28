package gh2011.models

import net.liftweb.json.JsonAST.{JArray, JValue}

case class ForkApplyEventPayload(repo: String, actor: String, head: String, original: String, actor_gravatar: String,
                                 commit: String)

object ForkApplyEventPayload
{
   def apply(json: JValue): Option[ForkApplyEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2l = gh3.node2Long(json)(_)

      val repo = n2s("repo")
      val actor = n2s("actor")
      val head = n2s("head")
      val original = n2s("original")
      val actor_gravatar = n2s("actor_gravatar")
      val commit = n2s("commit")

      val params = Seq(repo, actor, head, original, actor_gravatar, commit)

      if(params.forall(_.isDefined))
         Some(ForkApplyEventPayload(repo.get, actor.get, head.get, original.get, actor_gravatar.get, commit.get))
      else None
   }
}

