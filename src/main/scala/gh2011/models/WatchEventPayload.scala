package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class WatchEventPayload(repo: String, actor: String, actor_gravatar: String, action: String)

object WatchEventPayload
{
   def apply(json: JValue): Option[WatchEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)

      val repo = n2s("repo")
      val actor = n2s("actor")
      val actor_gravatar = n2s("actor_gravatar")
      val action = n2s("action")

      val params = Seq(repo, actor, actor_gravatar, action)

      if(params.forall(_.isDefined))
         Some(WatchEventPayload(repo.get, actor.get, actor_gravatar.get, action.get))
      else None
   }
}

