package gh3.models

import gh3._
import net.liftweb.json.JsonAST.{JArray, JNull, JString, JValue}
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
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)
      val n2os = node2OptionString(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)
      val n2b = node2Boolean(json)(_)
      
      val url = n2s("url")
      val labels_url = n2s("labels_url")
      val comments_url = n2s("comments_url")
      val events_url = n2s("events_url")
      val html_url = n2s("html_url")
      val id = n2l("id")
      val number = n2l("number")
      val title = n2s("title")
      val user = GH3Sender(json \ "user")
      val labels = (json \ "labels") match {
         case JArray(a) => Some(a.map(GH3Label(_).get))
         case _ => None
      }
      val state = n2s("state")
      val locked = n2b("locked")
      val assignee = n2os("assignee")
      val milestone = n2os("milestone")
      val comments = n2l("comments")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")
      val closed_at = (json \ "closed_at") match {
         case JString(x) => Some(Some(formatter.parseLocalDateTime(x.take(19))))
         case JNull => Some(None)
         case _ => None
      }
      val body = n2s("body")

      val params = Seq(url, labels_url, comments_url, events_url, html_url, id, number, title, user, labels, state, locked,
      assignee, milestone, comments, created_at, updated_at, closed_at, body)

      if(params.forall(_.isDefined))
         Some(new GH3Issue(url.get, labels_url.get, comments_url.get, events_url.get, html_url.get, id.get, number.get,
            title.get, user.get, labels.get, state.get, locked.get, assignee.get, milestone.get, comments.get, created_at.get,
            updated_at.get, closed_at.get, body.get))
      else None
   }
}
