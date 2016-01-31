package gh2013.payloads

import gh2013.models.GollumPage
import net.liftweb.json.JsonAST.{JArray, JValue}

case class GollumEventPayload(pages: Seq[GollumPage])

object GollumEventPayload
{
   def apply(json: JValue): Option[GollumEventPayload] =
   {
      (json \ "pages") match {
         case JArray(x) => Some(GollumEventPayload(x.map(e => GollumPage(e).get)))
         case _ => None
      }
   }
}