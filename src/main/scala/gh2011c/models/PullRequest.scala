package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class PullRequest(diff_url: Option[String], patch_url: Option[String], html_url: Option[String])

object PullRequest
{
   def apply(json: JValue): Option[PullRequest] =
   {
      val n2os = gh3.node2OptionString(json)(_)

      val diff_url = n2os("diff_url")
      val patch_url = n2os("patch_url")
      val html_url = n2os("html_url")

      val params = Seq(diff_url, patch_url, html_url)

      if(params.forall(_.isDefined)) Some(PullRequest(diff_url.get, patch_url.get, html_url.get))
      else None
   }
}