package gh3.models

import gh3._
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
      val n2s = node2String(json)(_)


      val page_name = n2s("page_name")
      val title = n2s("title")
      val summary = node2OptionString(json)("summary")
      val action = n2s("action")
      val sha = n2s("sha")
      val html_url = n2s("html_url")

      val params = Seq(page_name, title, summary, action, sha, html_url)

      if(params.forall(_.isDefined))
         Some(new GH3Page(page_name.get, title.get, summary.get, action.get, sha.get, html_url.get))
      else None
   }
}