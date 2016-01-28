package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class FollowEventPayload(target: FollowEventTarget, actor: String, actor_gravatar: String)

object FollowEventPayload
{
   def apply(json: JValue): Option[FollowEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val target = FollowEventTarget(json \ "target")
      val actor = n2s("actor")
      val actor_gravatar = n2s("actor_gravatar")

      if(Seq(target, actor, actor_gravatar).forall(_.isDefined))
         Some(FollowEventPayload(target.get, actor.get, actor_gravatar.get))
      else None
   }
}
