package gh3

import net.liftweb.json.JsonAST.JValue


case class GH3Page(  page_name: String,
                     title: String,
                     summary: Option[String],
                     action: String,
                     sha: String,
                     html_url: String)

object GH3Page
{
   def apply(json: JValue): Option[GH3Page] =
   {
      val page_name = node2String(json \ "page_name")
      val title = node2String(json \ "title")
      val summary = node2OptionString(json \ "summary")
      val action = node2String(json \ "action")
      val sha = node2String(json \ "sha")
      val html_url = node2String(json \ "html_url")

      val params = Seq(page_name, title, summary, action, sha, html_url)

      if(params.forall(_.isDefined))
         Some(new GH3Page(page_name.get, title.get, summary.get, action.get, sha.get, html_url.get))
      else None
   }
}