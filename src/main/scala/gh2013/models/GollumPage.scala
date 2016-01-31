package gh2013.models

import net.liftweb.json.JsonAST.JValue

case class GollumPage(title: String, action: String, html_url: String, page_name: String, sha: String,
                      summary: Option[String])

object GollumPage
{
   def apply(json: JValue): Option[GollumPage] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val title = n2s("title")
      val action = n2s("action")
      val html_url = n2s("html_url")
      val page_name = n2s("page_name")
      val sha = n2s("sha")
      val summary = n2os("summary")

      val params = Seq(title, action, html_url, page_name, sha, summary)

      if(params.forall(_.isDefined))
         Some(GollumPage(title.get, action.get, html_url.get, page_name.get, sha.get, summary.get))
      else None


   }
}
