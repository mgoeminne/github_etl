package gh3

import gh.Main
import net.liftweb.json.DefaultFormats
import net.liftweb.json.JsonAST.{JNull, JInt, JString, JValue}
import org.joda.time.LocalDateTime


case class GH3Comment(
                     url: String,
                     html_url: String,
                     id: Long,
                     user: GH3Sender,
                     position: Option[String],
                     line: Option[String],
                     path: Option[String],
                     commit_id: String,
                     created_at: LocalDateTime,
                     updated_at: LocalDateTime,
                     body: String
                     )

object GH3Comment
{

   def apply(json: JValue): Option[GH3Comment] =
   {
      val url = node2String(json \ "url")
      val html_url = node2String(json \ "html_url")
      val id = node2Long(json \ "id")
      val user = GH3Sender(json \ "user")

      val position = (json \ "position") match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case _ => None
      }

      val line = (json \ "line") match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case _ => None
      }

      val path = (json \ "path") match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case _ => None
      }

      val commit_id = node2String(json \ "commit_id")
      val created_at = node2String(json \ "created_at").map(x => Main.formatter.parseLocalDateTime(x take 19))
      val updated_at = node2String(json \ "updated_at").map(x => Main.formatter.parseLocalDateTime(x take 19))
      val body = node2String(json \ "body")

      if(Seq(url, html_url, id, user, position, line, path, commit_id, created_at, updated_at, body).forall(_.isDefined))
         Some(new GH3Comment( url.get, html_url.get, id.get, user.get, position.get, line.get, path.get, commit_id.get,
                              created_at.get, updated_at.get, body.get
         ))
      else None
   }
}
