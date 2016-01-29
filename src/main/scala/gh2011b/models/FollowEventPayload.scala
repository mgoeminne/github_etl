package gh2011b.models

import gh2011.models.FollowEventTarget
import net.liftweb.json.JsonAST.JValue

case class FollowEventPayload(target: FollowEventTarget)

object FollowEventPayload
{
   def apply(json: JValue): Option[FollowEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val target = FollowEventTarget(json \ "target")

      if(target.isDefined) Some(FollowEventPayload(target.get))
      else None
   }
}
