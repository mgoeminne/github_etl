package gh3

import net.liftweb.json.JsonAST.{JNull, JString, JArray, JValue}
import org.joda.time.LocalDateTime



case class GH3Issue(
                     url: String,
                     labels_url: String,
                     comments_url: String,
                     events_url: String,
                     html_url: String,
                     id: Long,
                     number: Long,
                     title: String,
                     user: GH3Sender,
                     labels: Seq[GH3Label],
                     state: String,
                     locked: Boolean,
                     assignee: Option[String],
                     milestone: Option[String],
                     comments: Long,
                     created_at: LocalDateTime,
                     updated_at: LocalDateTime,
                     closed_at: Option[LocalDateTime],
                     body: String
                   )

object GH3Issue
{
   def apply(json: JValue): Option[GH3Issue] =
   {
      val url = node2String(json \ "url")
      val labels_url = node2String(json \ "labels_url")
      val comments_url = node2String(json \ "comments_url")
      val events_url = node2String(json \ "events_url")
      val html_url = node2String(json \ "html_url")
      val id = node2Long(json \ "id")
      val number = node2Long(json \ "number")
      val title = node2String(json \ "title")
      val user = GH3Sender(json \ "user")
      val labels = (json \ "labels") match {
         case JArray(a) => a.map(GH3Label(_).get)
      }
      val state = node2String(json \ "state")
      val locked = node2Boolean(json \ "locked")
      val assignee = node2OptionString(json \ "assignee")
      val milestone = node2OptionString(json \ "milestone")
      val comments = node2Long(json \ "comments")
      val created_at = node2LocalDateTime(json \ "created_at")
      val updated_at = node2LocalDateTime(json \ "updated_at")
      val closed_at = (json \ "closed_at") match {
         case JString(x) => Some(Some(formatter.parseLocalDateTime(x.take(19))))
         case JNull => Some(None)
         case _ => None
      }
      val body = node2String(json \ "body")

      val params = Seq(url, labels_url, comments_url, events_url, html_url, id, number, title, user, state, locked,
      assignee, milestone, comments, created_at, updated_at, closed_at, body)

      if(params.forall(_.isDefined))
         Some(new GH3Issue(url.get, labels_url.get, comments_url.get, events_url.get, html_url.get, id.get, number.get,
            title.get, user.get, labels, state.get, locked.get, assignee.get, milestone.get, comments.get, created_at.get,
            updated_at.get, closed_at.get, body.get))
      else None
   }
}
