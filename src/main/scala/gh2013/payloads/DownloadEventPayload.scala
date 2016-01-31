package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class DownloadEventPayload(url: String, id: Long)

object DownloadEventPayload
{
   def apply(json: JValue): Option[DownloadEventPayload] =
   {
      val url = gh3.node2String(json)("url")
      val id  = gh3.node2Long(json)("id")

      if(Seq(url, id).forall(_.isDefined)) Some(DownloadEventPayload(url.get, id.get))
      else None
   }
}