package gh2011c.models

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class IssueComment(created_at: LocalDateTime, body: String, updated_at: LocalDateTime, url: String, id: Long,
                        user: IssueCommentUser)

object IssueComment
{
   def apply(json: JValue): Option[IssueComment] =
   {
      val n2ldt = gh3.node2LocalDateTime(json)(_)
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val created_at = n2ldt("created_at")
      val body = n2s("body")
      val updated_at = n2ldt("updated_at")
      val url = n2s("url")
      val id = n2l("id")
      val user = IssueCommentUser(json \ "user")

      val params = Seq(created_at, body, updated_at, url, id, user)

      if(params.forall(_.isDefined))
         Some(IssueComment(created_at.get, body.get, updated_at.get, url.get, id.get, user.get))
      else None
   }
}