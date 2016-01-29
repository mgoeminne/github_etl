package gh2011b.models

import net.liftweb.json.JsonAST.JValue


case class DownloadEventPayload(id: Long, url: String)

object DownloadEventPayload
{
   def apply(json: JValue): Option[DownloadEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val id = n2l("id")
      val url = n2s("url")

      val params = Seq(id, url)

      if(params.forall(_.isDefined)) Some(DownloadEventPayload(id.get, url.get))
      else None
   }
}
