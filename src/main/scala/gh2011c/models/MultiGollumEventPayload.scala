package gh2011c.models

import gh2011.models.PullRequest
import net.liftweb.json.JsonAST.{JArray, JValue}


case class MultiGollumEventPayload(pages: Seq[GollumPage])

object MultiGollumEventPayload
{
   def apply(json: JValue): Option[MultiGollumEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val pages = (json \ "pages") match {
         case JArray(x) => Some(x.map(e => GollumPage(e).get))
         case _ => None
      }

      if(pages.isDefined) Some(MultiGollumEventPayload(pages.get))
      else None
   }
}
