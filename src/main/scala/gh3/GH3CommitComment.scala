package gh3

import gh.Main
import net.liftweb.json.DefaultFormats
import net.liftweb.json.JsonAST.{JNull, JInt, JString, JValue}
import org.joda.time.LocalDateTime


case class GH3CommitComment(
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

object GH3CommitComment
{

   def apply(json: JValue): Option[GH3CommitComment] =
   {
      val n2s = node2String(json)(_)

      val url = n2s("url")
      val html_url = n2s("html_url")
      val id = node2Long(json)("id")
      val user = GH3Sender(json \ "user")

      val position = node2OptionString(json)("position")

      val line = node2OptionString(json)("line")

      val path = node2OptionString(json)("path")

      val commit_id = n2s("commit_id")
      val created_at = node2LocalDateTime(json)("created_at")
      val updated_at = node2LocalDateTime(json)("updated_at")
      val body = n2s("body")

      val params = Seq(url, html_url, id, user, position, line, path, commit_id, created_at, updated_at, body)

      println(params.map(_.isDefined))
      if(params.forall(_.isDefined))
         Some(new GH3CommitComment( url.get, html_url.get, id.get, user.get, position.get, line.get, path.get, commit_id.get,
                              created_at.get, updated_at.get, body.get
         ))
      else None
   }
}
