package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class FollowEventPayload(target: FollowEventTarget)

object FollowEventPayload
{
   def apply(json: JValue): Option[FollowEventPayload] =
   {
      val target = FollowEventTarget(json \ "target")

      if(target.isDefined) Some(FollowEventPayload(target.get))
      else None
   }
}