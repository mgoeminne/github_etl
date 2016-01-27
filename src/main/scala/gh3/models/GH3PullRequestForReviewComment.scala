package gh3.models

import gh3._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class GH3PullRequestForReviewComment(
                           url: String,
                           id: Long,
                           html_url: String,
                           diff_url: String,
                           patch_url: String,
                           issue_url: String,
                           number: Long,
                           state: String,
                           locked: Boolean,
                           title: String,
                           user: GH3Sender,
                           body: String,
                           created_at: LocalDateTime,
                           updated_at: LocalDateTime,
                           closed_at: Option[LocalDateTime],
                           merged_at: Option[LocalDateTime],
                           merge_commit_sha: Option[String],
                           assignee: Option[String],
                           milestone: Option[String],
                           commits_url: String,
                           review_comments_url: String,
                           review_comment_url: String,
                           statuses_url: String,
                           head: GH3Head,
                           base: GH3Base,
                           self_link: String,
                           html_link: String,
                           issue_link: String,
                           comments_link: String,
                           review_comments_link: String,
                           review_comment_link: String,
                           commits_link: String,
                           statuses_link: String
                         )

object GH3PullRequestForReviewComment
{
   def apply(json: JValue): Option[GH3PullRequestForReviewComment] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)
      val n2b = node2Boolean(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)
      val n2oldt = node2OptionLocalDateTime(json)(_)
      val n2os = node2OptionString(json)(_)

      val url = n2s("url")
      val id = n2l("id")
      val html_url = n2s("html_url")
      val diff_url = n2s("diff_url")
      val patch_url = n2s("patch_url")
      val issue_url = n2s("issue_url")
      val number = n2l("number")
      val state = n2s("state")
      val locked = n2b("locked")
      val title = n2s("title")
      val user = GH3Sender(json \ "user")
      val body = n2s("body")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")
      val closed_at = n2oldt("closed_at")
      val merged_at = n2oldt("merged_at")
      val merge_commit_sha = n2os("merge_commit_sha")
      val assignee = n2os("assignee")
      val milestone = n2os("milestone")
      val commits_url = n2s("commits_url")
      val review_comments_url = n2s("review_comments_url")
      val review_comment_url = n2s("review_comment_url")
      val comments_url = n2s("comments_url")
      val statuses_url = n2s("statuses_url")
      val head = GH3Head(json \ "head")
      val base = GH3Base(json \ "base")
      val self_link = node2String(json \ "_links" \ "self")("href")
      val html_link = node2String(json \ "_links" \ "html")("href")
      val issue_link = node2String(json \ "_links" \ "issue")("href")
      val comments_link = node2String(json \ "_links" \ "comments")("href")
      val statuses_link = node2String(json \ "_links" \ "statuses")("href")
      val review_comments_link = node2String(json \ "_links" \ "review_comments")("href")
      val review_comment_link = node2String(json \ "_links" \ "review_comment")("href")
      val commits_link = node2String(json \ "_links" \ "commits")("href")



      val params = Seq(
         url,
         id,
         html_url,
         diff_url,
         patch_url,
         issue_url,
         number,
         state,
         locked,
         title,
         user,
         body,
         created_at,
         updated_at,
         closed_at,
         merged_at,
         merge_commit_sha,
         assignee,
         milestone,
         commits_url,
         review_comments_url,
         review_comment_url,
         statuses_url,
         head,
         base,
         self_link,
         html_link,
         issue_link,
         comments_link,
         review_comments_link,
         review_comment_link,
         commits_link,
         statuses_link
      )

      if(params.forall(_.isDefined))
         Some(new GH3PullRequestForReviewComment(url.get,
            id.get,
            html_url.get,
            diff_url.get,
            patch_url.get,
            issue_url.get,
            number.get,
            state.get,
            locked.get,
            title.get,
            user.get,
            body.get,
            created_at.get,
            updated_at.get,
            closed_at.get,
            merged_at.get,
            merge_commit_sha.get,
            assignee.get,
            milestone.get,
            commits_url.get,
            review_comments_link.get,
            review_comment_link.get,
            statuses_url.get,
            head.get,
            base.get,
            self_link.get,
            html_link.get,
            issue_link.get,
            comments_link.get,
            review_comments_link.get,
            review_comment_link.get,
            commits_link.get,
            statuses_link.get))
      else None

   }
}
