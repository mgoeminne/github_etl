package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class PublicEventPayload()

object PublicEventPayload
{
   def apply(json: JValue): Option[PublicEventPayload] =
   {
      None
   }
}
