package gh3

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime


case class GH3Forkee(
                     id: Long,
                     name: String,
                     full_name: String,
                     owner: GH3Sender,
                     `private`: Boolean,
                     html_url: String,
                     description: String,
                     fork: Boolean,
                     url: String,
                     forks_url: String,
                     keys_url: String,
                     collaborators_url: String,
                     teams_url: String,
                     hooks_url: String,
                     issue_events_url: String,
                     events_url: String,
                     assignees_url: String,
                     branches_url: String,
                     tags_url: String,
                     blobs_url: String,
                     git_tags_url: String,
                     git_refs_url: String,
                     trees_url: String,
                     statuses_url: String,
                     languages_url: String,
                     stargazers_url: String,
                     contributors_url: String,
                     subscribers_url: String,
                     subscription_url: String,
                     commits_url: String,
                     git_commits_url: String,
                     comments_url: String,
                     issue_comment_url: String,
                     contents_url: String,
                     compare_url: String,
                     merges_url: String,
                     archive_url: String,
                     downloads_url: String,
                     issues_url: String,
                     pulls_url: String,
                     milestones_url: String,
                     notifications_url: String,
                     labels_url: String,
                     releases_url: String,
                     created_at: LocalDateTime,
                     updated_at: LocalDateTime,
                     pushed_at: LocalDateTime,
                     git_url: String,
                     ssh_url: String,
                     clone_url: String,
                     svn_url: String,
                     homepage: Option[String],
                     size: Long,
                     stargazers_count: Int,
                     watchers_count: Int,
                     language: Option[String],
                     has_issues: Boolean,
                     has_downloads: Boolean,
                     has_wiki: Boolean,
                     has_pages: Boolean,
                     forks_count: Int,
                     mirror_url: Option[String],
                     open_issues_count: Int,
                     forks: Int,
                     open_issues: Int,
                     watchers: Int,
                     default_branch: String,
                     public: Boolean
                    )

object GH3Forkee
{
   def apply(json: JValue): Option[GH3Forkee] =
   {
      val id = node2Long(json \ "id")
      val name = node2String(json \ "name")
      val full_name = node2String(json \ "full_name")
      val owner = GH3Sender(json \ "owner")
      val `private` = node2Boolean(json \ "private")
      val html_url = node2String(json \ "html_url")
      val description = node2String(json \ "description")
      val fork = node2Boolean(json \ "fork")
      val url = node2String(json \ "url")
      val forks_url = node2String(json \ "forks_url")
      val keys_url = node2String(json \ "keys_url")
      val collaborators_url = node2String(json \ "collaborators_url")
      val teams_url = node2String(json \ "teams_url")
      val hooks_url = node2String(json \ "hooks_url")
      val issue_events_url = node2String(json \ "issue_events_url")
      val events_url = node2String(json \ "events_url")
      val assignees_url = node2String(json \ "assignees_url")
      val branches_url = node2String(json \ "branches_url")
      val tags_url = node2String(json \ "tags_url")
      val blobs_url = node2String(json \ "blobs_url")
      val git_tags_url = node2String(json \ "git_tags_url")
      val git_refs_url = node2String(json \ "git_refs_url")
      val trees_url = node2String(json \ "trees_url")
      val statuses_url = node2String(json \ "statuses_url")
      val languages_url = node2String(json \ "languages_url")
      val stargazers_url = node2String(json \ "stargazers_url")
      val contributors_url = node2String(json \ "contributors_url")
      val subscribers_url = node2String(json \ "subscribers_url")
      val subscription_url = node2String(json \ "subscription_url")
      val commits_url = node2String(json \ "commits_url")
      val git_commits_url = node2String(json \ "git_commits_url")
      val comments_url = node2String(json \ "comments_url")
      val issue_comment_url = node2String(json \ "issue_comment_url")
      val contents_url = node2String(json \ "contents_url")
      val compare_url = node2String(json \ "compare_url")
      val merges_url = node2String(json \ "merges_url")
      val archive_url = node2String(json \ "archive_url")
      val downloads_url = node2String(json \ "downloads_url")
      val issues_url = node2String(json \ "issues_url")
      val pulls_url = node2String(json \ "pulls_url")
      val milestones_url = node2String(json \ "milestones_url")
      val notifications_url = node2String(json \ "notifications_url")
      val labels_url = node2String(json \ "labels_url")
      val releases_url = node2String(json \ "releases_url")
      val created_at = node2LocalDateTime(json \ "created_at")
      val updated_at = node2LocalDateTime(json \ "updated_at")
      val pushed_at = node2LocalDateTime(json \ "pushed_at")
      val git_url = node2String(json \ "git_url")
      val ssh_url = node2String(json \ "ssh_url")
      val clone_url = node2String(json \ "clone_url")
      val svn_url = node2String(json \ "svn_url")
      val homepage = node2OptionString(json \ "homepage")
      val size = node2Long(json \ "size")
      val stargazers_count = node2Long(json \ "stargazers_count").map(_.toInt)
      val watchers_count = node2Long(json \ "watchers_count").map(_.toInt)
      val language = node2OptionString(json \ "language")
      val has_issues = node2Boolean(json \ "has_issues")
      val has_downloads = node2Boolean(json \ "has_downloads")
      val has_wiki = node2Boolean(json \ "has_wiki")
      val has_pages = node2Boolean(json \ "has_pages")
      val forks_count = node2Long(json \ "forks_count").map(_.toInt)
      val mirror_url = node2OptionString(json \ "mirror_url")
      val open_issues_count = node2Long(json \ "open_issues_count").map(_.toInt)
      val forks = node2Long(json \ "forks").map(_.toInt)
      val open_issues = node2Long(json \ "open_issues").map(_.toInt)
      val watchers = node2Long(json \ "watchers").map(_.toInt)
      val default_branch = node2String(json \ "default_branch")
      val public = node2Boolean(json \ "public")

      val params = Seq(
         id,
         name,
         full_name,
         owner,
         `private`,
         html_url,
         description,
         fork,
         url,
         forks_url,
         keys_url,
         collaborators_url,
         teams_url,
         hooks_url,
         issue_events_url,
         events_url,
         assignees_url,
         branches_url,
         tags_url,
         blobs_url,
         git_tags_url,
         git_refs_url,
         trees_url,
         statuses_url,
         languages_url,
         stargazers_url,
         contributors_url,
         subscribers_url,
         subscription_url,
         commits_url,
         git_commits_url,
         comments_url,
         issue_comment_url,
         contents_url,
         compare_url,
         merges_url,
         archive_url,
         downloads_url,
         issues_url,
         pulls_url,
         milestones_url,
         notifications_url,
         labels_url,
         releases_url,
         created_at,
         updated_at,
         pushed_at,
         git_url,
         ssh_url,
         clone_url,
         svn_url,
         homepage,
         size,
         stargazers_count,
         watchers_count,
         language,
         has_issues,
         has_downloads,
         has_wiki,
         has_pages,
         forks_count,
         mirror_url,
         open_issues_count,
         forks,
         open_issues,
         watchers,
         default_branch,
         public)

      if (params.forall(_.isDefined))
         Some(new GH3Forkee(id.get,
            name.get,
            full_name.get,
            owner.get,
            `private`.get,
            html_url.get,
            description.get,
            fork.get,
            url.get,
            forks_url.get,
            keys_url.get,
            collaborators_url.get,
            teams_url.get,
            hooks_url.get,
            issue_events_url.get,
            events_url.get,
            assignees_url.get,
            branches_url.get,
            tags_url.get,
            blobs_url.get,
            git_tags_url.get,
            git_refs_url.get,
            trees_url.get,
            statuses_url.get,
            languages_url.get,
            stargazers_url.get,
            contributors_url.get,
            subscribers_url.get,
            subscription_url.get,
            commits_url.get,
            git_commits_url.get,
            comments_url.get,
            issue_comment_url.get,
            contents_url.get,
            compare_url.get,
            merges_url.get,
            archive_url.get,
            downloads_url.get,
            issues_url.get,
            pulls_url.get,
            milestones_url.get,
            notifications_url.get,
            labels_url.get,
            releases_url.get,
            created_at.get,
            updated_at.get,
            pushed_at.get,
            git_url.get,
            ssh_url.get,
            clone_url.get,
            svn_url.get,
            homepage.get,
            size.get,
            stargazers_count.get,
            watchers_count.get,
            language.get,
            has_issues.get,
            has_downloads.get,
            has_wiki.get,
            has_pages.get,
            forks_count.get,
            mirror_url.get,
            open_issues_count.get,
            forks.get,
            open_issues.get,
            watchers.get,
            default_branch.get,
            public.get))
      else None
   }
}
