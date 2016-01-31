package gh2013.models

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class PullRequest(milestone: Option[String], comments: Long, comments_url: String, review_comments: Long,
                       review_comments_url: String, deletions: Long, number: Long, created_at: LocalDateTime,
                       merge_commit_sha: String, closed_at: Option[LocalDateTime], url: String,
                       merged_at: Option[LocalDateTime], comments_link: String, review_comments_link: String,
                       self_link: String, issue_link: String, html_link: String, additions: Long, id: Long,
                       mergeable: Option[String], state: String, mergeable_state: String, body: String,
                       changed_files: Long, patch_url: String, merged: Boolean, commits_url: String, html_url: String,
                       user: User, diff_url: String, review_comment_url: String,
                       updated_at: Option[LocalDateTime], head: Commit, merged_by: User, issue_url: String,
                       base: Commit, title: String, commits: Long, assignee: Option[String])

object PullRequest
{
   def apply(json: JValue): Option[PullRequest] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)
      val n2oldt = gh3.node2OptionLocalDateTime(json)(_)
      val n2b = gh3.node2Boolean(json)(_)

      val milestone = n2os("milestone")
      val comments = n2l("comments")
      val comments_url = n2s("comments_url")
      val review_comments = n2l("review_comments")
      val review_comments_url = n2s("review_comments_url")
      val deletions = n2l("deletions")
      val number = n2l("number")
      val created_at = n2ldt("created_at")
      val merge_commit_sha = n2s("merge_commit_sha")
      val closed_at = n2oldt("closed_at")
      val url = n2s("url")
      val merged_at = n2oldt("merged_at")
      val comments_link = gh3.node2String(json \ "_links" \ "comments")("href")
      val review_comments_link = gh3.node2String(json \ "_links" \ "review_comments")("href")
      val self_link = gh3.node2String(json \ "_links" \ "self")("href")
      val issue_link = gh3.node2String(json \ "_links" \ "issue")("href")
      val html_link = gh3.node2String(json \ "_links" \ "html")("href")
      val additions = n2l("additions")
      val id = n2l("id")
      val mergeable = n2os("mergeable")
      val state = n2s("state")
      val mergeable_state = n2s("mergeable_state")
      val body = n2s("body")
      val changed_files = n2l("changed_files")
      val patch_url= n2s("patch_url")
      val merged = n2b("merged")
      val commits_url = n2s("commits_url")
      val html_url = n2s("html_url")
      val user = User(json \ "user")
      val diff_url = n2s("diff_url")
      val review_comment_url = n2s("review_comment_url")
      val updated_at = n2oldt("updated_at")
      val head = Commit(json \ "head")
      val merged_by = User(json \ "merged_by")
      val issue_url = n2s("issue_url")
      val base = Commit(json \ "base")
      val title = n2s("title")
      val commits = n2l("commits")
      val assignee = n2os("assignee")

      val params = Seq(milestone, comments, comments_url, review_comments, review_comments_url, deletions, number,
         created_at, merge_commit_sha, closed_at, url, merged_at, comments_link, review_comments_link,
         review_comments_link, self_link, issue_link, html_link, additions, mergeable, state, mergeable_state, body,
         changed_files, patch_url, merged, commits_url, html_url, user, diff_url, review_comment_url, updated_at, head,
         merged_by, issue_url, base, title, commits, assignee)

      if(params.forall(_.isDefined))
         Some(PullRequest(milestone.get, comments.get, comments_url.get, review_comments.get, review_comments_url.get,
            deletions.get, number.get, created_at.get, merge_commit_sha.get, closed_at.get, url.get, merged_at.get,
            comments_link.get, review_comments_link.get, self_link.get, issue_link.get, html_link.get, additions.get,
            id.get, mergeable.get, state.get, mergeable_state.get, body.get, changed_files.get, patch_url.get, merged.get,
            commits_url.get, html_url.get, user.get, diff_url.get, review_comment_url.get, updated_at.get, head.get,
            merged_by.get, issue_url.get, base.get, title.get, commits.get, assignee.get))
      else None


   }
}