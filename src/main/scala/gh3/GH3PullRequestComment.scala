package gh3

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class GH3PullRequestComment(
                                 url: String,
                                 id: Long,
                                 diff_hunk: String,
                                 path: String,
                                 position: Int,
                                 original_position: Int,
                                 commit_id: String,
                                 original_commit_id: String,
                                 user: GH3Sender,
                                 body: String,
                                 created_at: LocalDateTime,
                                 updated_at: LocalDateTime,
                                 html_url: String,
                                 self_link: String,
                                 html_link: String,
                                 pull_request_link: String
                                )

object GH3PullRequestComment
{
   def apply(json: JValue): Option[GH3PullRequestComment] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)

      val url = n2s("url")
      val id = n2l("id")
      val diff_hunk = n2s("diff_hunk")
      val path = n2s("path")
      val position = n2l("position").map(_.toInt)
      val original_position = n2l("original_position").map(_.toInt)
      val commit_id = n2s("commit_id")
      val original_commit_id = n2s("original_commit_id")
      val user = GH3Sender(json \ "user")
      val body = n2s("body")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")
      val html_url = n2s("html_url")
      val self_link = node2String(json \ "_links" \ "self")("href")
      val html_link = node2String(json \ "_links" \ "html")("href")
      val pull_request_link = node2String(json \ "_links" \ "pull_request")("href")

      val params = Seq(url, id, diff_hunk, path, position, original_position, commit_id, original_commit_id,
      user, body, created_at, updated_at, html_url, self_link, html_link, pull_request_link)

      if(params.forall(_.isDefined))
         Some(new GH3PullRequestComment(url.get, id.get, diff_hunk.get, path.get, position.get, original_position.get,
         commit_id.get, original_commit_id.get, user.get, body.get, created_at.get, updated_at.get, html_url.get,
         self_link.get, html_link.get, pull_request_link.get))
      else None
   }
}
