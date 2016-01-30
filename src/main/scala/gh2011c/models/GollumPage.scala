package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class GollumPage(title: String, summary: Option[String], sha: String, page_name: String, action: String)

object GollumPage
{
   def apply(json: JValue): Option[GollumPage] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val title = n2s("title")
      val summary = n2os("summary")
      val sha = n2s("sha")
      val page_name = n2s("page_name")
      val action = n2s("action")

      val params = Seq(title, summary, sha, page_name, action)

      if(params.forall(_.isDefined)) Some(GollumPage(title.get, summary.get, sha.get, page_name.get, action.get))
      else None
   }
}