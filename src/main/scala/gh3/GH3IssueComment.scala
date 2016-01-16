package gh3

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class GH3IssueComment(
                              url: String,
                              html_url: String,
                              issue_url: String,
                              id: Long,
                              user: GH3Sender,
                              created_at: LocalDateTime,
                              updated_at: LocalDateTime,
                              body: String
                          )

object GH3IssueComment
{
   def apply(json: JValue): Option[GH3IssueComment] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)
      val n2os = node2OptionString(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)
      val n2b = node2Boolean(json)(_)
      
      val url = n2s("url")
      val html_url = n2s("url")
      val issue_url = n2s("url")
      val id = n2l("id")
      val user = GH3Sender(json \ "user")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")
      val body = n2s("body")

      val params = Seq(url, html_url, issue_url, user, created_at, updated_at, body)

      if(params.forall(_.isDefined))
         Some(new GH3IssueComment(url.get, html_url.get, issue_url.get, id.get, user.get, created_at.get,
                                  updated_at.get, body.get))
      else None
   }
}