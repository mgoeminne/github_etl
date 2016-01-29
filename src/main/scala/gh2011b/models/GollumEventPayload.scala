package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class GollumEventPayload(action: String)

object GollumEventPayload
{
   def apply(json: JValue): Option[GollumEventPayload] =
   {
      None
   }
}
