package gh3

import gh.Main
import net.liftweb.json.DefaultFormats
import net.liftweb.json.JsonAST._
import org.joda.time.LocalDateTime

case class GH3Repository(  id: Long,
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
                           stargazers_count: Long,
                           watchers_count: Long,
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
                           default_branch: String
                        )

object GH3Repository
{
   def apply(json: JValue): Option[GH3Repository] =
   {
      implicit val formats = DefaultFormats
      
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)
      val n2b = node2Boolean(json)(_)
      
      val id = n2l("id")
      val name = n2s("name")
      val full_name = n2s("full_name")
      val owner = GH3Sender(json \ "owner")
      val `private` = n2b("private")
      val html_url = n2s("html_url")
      val description = n2s("description")
      val fork = n2b("fork")
      val url = n2s("url")
      val forks_url = n2s("forks_url")
      val keys_url = n2s("keys_url")
      val collaborators_url = n2s("collaborators_url")
      val teams_url = n2s("teams_url")
      val hooks_url = n2s("hooks_url")
      val issue_events_url = n2s("issue_events_url")
      val events_url = n2s("events_url")
      val assignees_url = n2s("assignees_url")
      val branches_url = n2s("branches_url")
      val tags_url = n2s("tags_url")
      val blobs_url = n2s("blobs_url")
      val git_tags_url = n2s("git_tags_url")
      val git_refs_url = n2s("git_refs_url")
      val trees_url = n2s("trees_url")
      val statuses_url = n2s("statuses_url")
      val languages_url = n2s("languages_url")
      val stargazers_url = n2s("stargazers_url")
      val contributors_url = n2s("contributors_url")
      val subscribers_url = n2s("subscribers_url")
      val subscription_url = n2s("subscription_url")
      val commits_url = n2s("commits_url")
      val git_commits_url = n2s("git_commits_url")
      val comments_url = n2s("comments_url")
      val issue_comment_url = n2s("issue_comment_url")
      val contents_url = n2s("contents_url")
      val compare_url = n2s("compare_url")
      val merges_url = n2s("merges_url")
      val archive_url = n2s("archive_url")
      val downloads_url = n2s("downloads_url")
      val issues_url = n2s("issues_url")
      val pulls_url = n2s("pulls_url")
      val milestones_url = n2s("milestones_url")
      val notifications_url = n2s("notifications_url")
      val labels_url = n2s("labels_url")
      val releases_url = n2s("releases_url")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")
      val pushed_at = n2ldt("pushed_at")
      val git_url = n2s("git_url")
      val ssh_url = n2s("ssh_url")
      val clone_url = n2s("clone_url")
      val svn_url = n2s("svn_url")
      val homepage = node2OptionString(json)("homepage")
      val size = n2l("size")
      val stargazers_count = n2l("stargazers_count")
      val watchers_count = n2l("watchers_count")
      val language = node2OptionString(json)("language")
      val has_issues = n2b("has_issues")
      val has_downloads = n2b("has_downloads")
      val has_wiki = n2b("has_wiki")
      val has_pages = n2b("has_pages")
      val forks_count = n2l("forks_count").map(_.toInt)
      val mirror_url = node2OptionString(json)("mirror_url")
      val open_issues_count = n2l("open_issues_count").map(_.toInt)
      val forks = n2l("forks").map(_.toInt)
      val open_issues = n2l("open_issues").map(_.toInt)
      val default_branch = n2s("default_branch")

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
         default_branch)

      println(params.map(_.isDefined))

      if(params.forall(_.isDefined)){
         Some(new GH3Repository(
            id.get,
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
            default_branch.get
         ))
      }
      else None
   }
}
