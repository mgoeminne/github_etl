package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class GollumEventPayload(title: String, summary: Option[String], sha: String, page_name: String, action: String)

object GollumEventPayload
{
   def apply(json: JValue): Option[GollumEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val title = n2s("title")
      val summary = n2os("summary")
      val sha = n2s("sha")
      val page_name = n2s("page_name")
      val action = n2s("action")

      val params = Seq(title, summary, sha, page_name, action)

      if(params.forall(_.isDefined))
         Some(GollumEventPayload(title.get, summary.get, sha.get, page_name.get, action.get))
      else None
   }
}
