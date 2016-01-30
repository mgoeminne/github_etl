package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class ForkEventPayload()

object ForkEventPayload
{
   def apply(json: JValue): Option[ForkEventPayload] = Some(ForkEventPayload())
}
