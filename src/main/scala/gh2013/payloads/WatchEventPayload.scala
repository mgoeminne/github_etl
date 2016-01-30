package gh2013.payloads

import gh2013.models.SHA
import net.liftweb.json.JsonAST.{JArray, JValue}

case class WatchEventPayload(action: String)

object WatchEventPayload
{
   def apply(json: JValue): Option[WatchEventPayload] =
   {
      val n2l = gh3.node2Long(json)(_)
      val n2s = gh3.node2String(json)(_)

      val action = n2s("action")

      if(action.isDefined) Some(WatchEventPayload(action.get))
      else None
   }
}
