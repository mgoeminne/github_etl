package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class GistEventPayload(desc: String, name: String, id: Long, url: String, action: String)

object GistEventPayload
{
   def apply(json: JValue): Option[GistEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)

      val desc = n2s("desc")
      val name = n2s("name")
      val id = gh3.node2Long(json)("id")
      val url = n2s("url")
      val action = n2s("action")

      val params = Seq(desc, name, id, url, action)

      if(params.forall(_.isDefined)) Some(GistEventPayload(desc.get, name.get, id.get, url.get, action.get))
      else None
   }
}
