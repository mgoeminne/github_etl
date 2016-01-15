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
      val url = node2String(json \ "url")
      val html_url = node2String(json \ "url")
      val issue_url = node2String(json \ "url")
      val id = node2Long(json \ "id")
      val user = GH3Sender(json \ "user")
      val created_at = node2LocalDateTime(json \ "created_at")
      val updated_at = node2LocalDateTime(json \ "updated_at")
      val body = node2String(json \ "body")

      val params = Seq(url, html_url, issue_url, user, created_at, updated_at, body)

      if(params.forall(_.isDefined))
         Some(new GH3IssueComment(url.get, html_url.get, issue_url.get, id.get, user.get, created_at.get,
                                  updated_at.get, body.get))
      else None
   }
}