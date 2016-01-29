package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class PublicEventPayload()

object PublicEventPayload
{
   def apply(json: JValue): Option[PublicEventPayload] = Some(PublicEventPayload())
}

