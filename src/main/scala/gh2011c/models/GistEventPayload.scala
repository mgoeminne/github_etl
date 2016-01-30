package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class GistEventPayload(name: String, desc: Option[String], id: Long, url: String, action: String)

object GistEventPayload
{
   def apply(json: JValue): Option[GistEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val name = n2s("name")
      val desc = n2os("desc")
      val id = n2l("id")
      val url = n2s("url")
      val action = n2s("action")

      val params = Seq(name, desc, id, url, action)

      if(params.forall(_.isDefined)) Some(GistEventPayload(name.get, desc.get, id.get, url.get, action.get))
      else None
   }
}
