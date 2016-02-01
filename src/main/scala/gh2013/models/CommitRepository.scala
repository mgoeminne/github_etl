package gh2013.models

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class CommitRepository(events_url: String, comments_url: String, full_name: String, open_issues_count: Long,
   hooks_url: String, git_commits_url: String, created_at: LocalDateTime, git_refs_url: String, git_url: String, size: Long,
   pushed_at: LocalDateTime, url: String, open_issues: Long, merges_url: String, statuses_url: String,
   id: Long, git_tags_url: String, contributors_url: String, has_downloads: Boolean, stargazers_url: String,
   subscription_url: String, has_issues: Boolean, compare_url: String, forks_count: Long, clone_url: String,
   contents_url: String, master_branch: Option[String], mirror_url: Option[String], fork: Boolean, blobs_url: String,
   branches_url: String, trees_url: String, `private`: Boolean, watchers: Long, teams_url: String,
   downloads_url: String, default_branch: Option[String], forks_url: String, assignees_url: String, svn_url: String,
   archive_url: String, subscribers_url: String, commits_url: String, issues_url: String, html_url: String, tags_url: String,
   updated_at: LocalDateTime, milestones_url: String, watchers_count: Long, languages_url: String,
   notifications_url: String, ssh_url: String, name: String, description: String, labels_url: String, language: String,
   collaborators_url: String, homepage: String, keys_url: String, issue_events_url: String, issue_comment_url: String,
   owner: User, has_wiki: Boolean)

object CommitRepository
{
   def apply(json: JValue): Option[CommitRepository] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)
      val n2b = gh3.node2Boolean(json)(_)

      val events_url = n2s("events_url")
      val comments_url = n2s("comments_url")
      val full_name = n2s("full_name")
      val open_issues_count = n2l("open_issues_count")
      val hooks_url = n2s("hooks_url")
      val git_commits_url = n2s("git_commits_url")
      val created_at = n2ldt("created_at")
      val git_refs_url = n2s("git_refs_url")
      val git_url = n2s("git_url")
      val size = n2l("size")
      val pushed_at = n2ldt("pushed_at")
      val url = n2s("url")
      val open_issues = n2l("open_issues")
      val merges_url = n2s("merges_url")
      val statuses_url = n2s("statuses_url")
      val id = n2l("id")
      val git_tags_url = n2s("git_tags_url")
      val contributors_url = n2s("contributors_url")
      val has_downloads = n2b("has_downloads")
      val stargazers_url = n2s("stargazers_url")
      val subscription_url = n2s("subscription_url")
      val has_issues = n2b("has_issues")
      val compare_url = n2s("compare_url")
      val forks_count = n2l("forks_count")
      val clone_url = n2s("clone_url")
      val contents_url = n2s("contents_url")
      val master_branch = n2os("master_branch")
      val mirror_url = n2os("mirror_url")
      val fork = n2b("fork")
      val blobs_url = n2s("blobs_url")
      val branches_url = n2s("branches_url")
      val trees_url = n2s("trees_url")
      val `private` = n2b("private")
      val watchers = n2l("watchers")
      val teams_url = n2s("teams_url")
      val downloads_url = n2s("downloads_url")
      val default_branch = n2os("default_branch")
      val forks_url = n2s("forks_url")
      val assignees_url = n2s("assignees_url")
      val svn_url = n2s("svn_url")
      val archive_url = n2s("archive_url")
      val subscribers_url = n2s("subscribers_url")
      val commits_url = n2s("commits_url")
      val issues_url = n2s("issues_url")
      val html_url = n2s("html_url")
      val tags_url = n2s("tags_url")
      val updated_at = n2ldt("updated_at")
      val milestones_url = n2s("milestones_url")
      val watchers_count = n2l("watchers_count")
      val languages_url = n2s("languages_url")
      val notifications_url = n2s("notifications_url")
      val ssh_url = n2s("ssh_url")
      val name = n2s("name")
      val description = n2s("description")
      val labels_url = n2s("labels_url")
      val language = n2s("language")
      val collaborators_url = n2s("collaborators_url")
      val homepage = n2s("homepage")
      val keys_url = n2s("keys_url")
      val issue_events_url = n2s("issue_events_url")
      val issue_comment_url = n2s("issue_comment_url")
      val owner = User(json \ "owner")
      val has_wiki = n2b("has_wiki")

      val params = Seq(events_url, comments_url, full_name, open_issues_count, hooks_url, git_commits_url, created_at,
         git_refs_url, git_url, size, pushed_at, url, open_issues, merges_url, statuses_url, id, git_tags_url,
         contributors_url, has_downloads, stargazers_url, subscription_url, has_issues, compare_url, forks_count,
         clone_url, contents_url, master_branch, mirror_url, fork, blobs_url, branches_url, trees_url, `private`,
         watchers, teams_url, downloads_url, default_branch, forks_url, assignees_url, svn_url, archive_url, subscribers_url,
         commits_url, issues_url, html_url, tags_url, updated_at, milestones_url, watchers_count, languages_url,
         notifications_url, ssh_url, name, description, labels_url, language, collaborators_url, homepage, keys_url,
         issue_events_url, issue_comment_url, owner, has_wiki)

      if(params.forall(_.isDefined))
         Some(new CommitRepository(events_url.get, comments_url.get, full_name.get, open_issues_count.get, hooks_url.get,
            git_commits_url.get, created_at.get, git_refs_url.get, git_url.get, size.get, pushed_at.get, url.get,
            open_issues.get, merges_url.get, statuses_url.get, id.get, git_tags_url.get, contributors_url.get,
            has_downloads.get, stargazers_url.get, subscription_url.get, has_issues.get, compare_url.get, forks_count.get,
            clone_url.get, contents_url.get, master_branch.get, mirror_url.get, fork.get, blobs_url.get, branches_url.get,
            trees_url.get, `private`.get, watchers.get, teams_url.get, downloads_url.get, default_branch.get, forks_url.get,
            assignees_url.get, svn_url.get, archive_url.get, subscribers_url.get, commits_url.get, issues_url.get,
            html_url.get, tags_url.get, updated_at.get, milestones_url.get, watchers_count.get, languages_url.get,
            notifications_url.get, ssh_url.get, name.get, description.get, labels_url.get, language.get, collaborators_url.get,
            homepage.get, keys_url.get, issue_events_url.get, issue_comment_url.get, owner.get, has_wiki.get))
      else None
   }
}
