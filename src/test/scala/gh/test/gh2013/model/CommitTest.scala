import gh2013.models.{Commit}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class CommitTest extends FlatSpec with Matchers
{
   "A valid Commit" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "events_url":"https://api.github.com/repos/tnm/rugged/events",
           |        "comments_url":"https://api.github.com/repos/tnm/rugged/comments{/number}",
           |        "full_name":"tnm/rugged",
           |        "open_issues_count":0,
           |        "hooks_url":"https://api.github.com/repos/tnm/rugged/hooks",
           |        "git_commits_url":"https://api.github.com/repos/tnm/rugged/git/commits{/sha}",
           |        "created_at":"2012-12-17T22:00:58Z",
           |        "git_refs_url":"https://api.github.com/repos/tnm/rugged/git/refs{/sha}",
           |        "git_url":"git://github.com/tnm/rugged.git",
           |        "size":248,
           |        "pushed_at":"2012-12-31T23:19:30Z",
           |        "url":"https://api.github.com/repos/tnm/rugged",
           |        "open_issues":0,
           |        "merges_url":"https://api.github.com/repos/tnm/rugged/merges",
           |        "statuses_url":"https://api.github.com/repos/tnm/rugged/statuses/{sha}",
           |        "id":7213068,
           |        "git_tags_url":"https://api.github.com/repos/tnm/rugged/git/tags{/sha}",
           |        "contributors_url":"https://api.github.com/repos/tnm/rugged/contributors",
           |        "has_downloads":true,
           |        "stargazers_url":"https://api.github.com/repos/tnm/rugged/stargazers",
           |        "subscription_url":"https://api.github.com/repos/tnm/rugged/subscription",
           |        "has_issues":false,
           |        "compare_url":"https://api.github.com/repos/tnm/rugged/compare/{base}...{head}",
           |        "forks_count":0,
           |        "clone_url":"https://github.com/tnm/rugged.git",
           |        "contents_url":"https://api.github.com/repos/tnm/rugged/contents/{+path}",
           |        "master_branch":"development",
           |        "mirror_url":null,
           |        "fork":true,
           |        "blobs_url":"https://api.github.com/repos/tnm/rugged/git/blobs{/sha}",
           |        "branches_url":"https://api.github.com/repos/tnm/rugged/branches{/branch}",
           |        "trees_url":"https://api.github.com/repos/tnm/rugged/git/trees{/sha}",
           |        "private":false,
           |        "watchers":1,
           |        "teams_url":"https://api.github.com/repos/tnm/rugged/teams",
           |        "downloads_url":"https://api.github.com/repos/tnm/rugged/downloads",
           |        "default_branch":"development",
           |        "forks_url":"https://api.github.com/repos/tnm/rugged/forks",
           |        "assignees_url":"https://api.github.com/repos/tnm/rugged/assignees{/user}",
           |        "svn_url":"https://github.com/tnm/rugged",
           |        "archive_url":"https://api.github.com/repos/tnm/rugged/{archive_format}{/ref}",
           |        "subscribers_url":"https://api.github.com/repos/tnm/rugged/subscribers",
           |        "commits_url":"https://api.github.com/repos/tnm/rugged/commits{/sha}",
           |        "issues_url":"https://api.github.com/repos/tnm/rugged/issues{/number}",
           |        "html_url":"https://github.com/tnm/rugged",
           |        "tags_url":"https://api.github.com/repos/tnm/rugged/tags{/tag}",
           |        "updated_at":"2012-12-31T23:19:33Z",
           |        "milestones_url":"https://api.github.com/repos/tnm/rugged/milestones{/number}",
           |        "watchers_count":1,
           |        "languages_url":"https://api.github.com/repos/tnm/rugged/languages",
           |        "notifications_url":"https://api.github.com/repos/tnm/rugged/notifications{?since,all,participating}",
           |        "ssh_url":"git@github.com:tnm/rugged.git",
           |        "name":"rugged",
           |        "description":"ruby bindings to libgit2",
           |        "labels_url":"https://api.github.com/repos/tnm/rugged/labels{/name}",
           |        "language":"C",
           |        "collaborators_url":"https://api.github.com/repos/tnm/rugged/collaborators{/collaborator}",
           |        "homepage":"",
           |        "keys_url":"https://api.github.com/repos/tnm/rugged/keys{/key_id}",
           |        "issue_events_url":"https://api.github.com/repos/tnm/rugged/issues/events{/number}",
           |        "forks":0,
           |        "pulls_url":"https://api.github.com/repos/tnm/rugged/pulls{/number}",
           |        "issue_comment_url":"https://api.github.com/repos/tnm/rugged/issues/comments/{number}",
           |        "owner":{
           |            "events_url":"https://api.github.com/users/tnm/events{/privacy}",
           |            "repos_url":"https://api.github.com/users/tnm/repos",
           |            "url":"https://api.github.com/users/tnm",
           |            "organizations_url":"https://api.github.com/users/tnm/orgs",
           |            "id":126905,
           |            "avatar_url":"https://secure.gravatar.com/avatar/803993dc11765d89aee137f29aa05d3a?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |            "gravatar_id":"803993dc11765d89aee137f29aa05d3a",
           |            "type":"User",
           |            "received_events_url":"https://api.github.com/users/tnm/received_events",
           |            "subscriptions_url":"https://api.github.com/users/tnm/subscriptions",
           |            "starred_url":"https://api.github.com/users/tnm/starred{/owner}{/repo}",
           |            "login":"tnm",
           |            "followers_url":"https://api.github.com/users/tnm/followers",
           |            "following_url":"https://api.github.com/users/tnm/following",
           |            "gists_url":"https://api.github.com/users/tnm/gists{/gist_id}"
           |        },
           |        "has_wiki":false
           |    },
           |    "label":"tnm:update-date",
           |    "sha":"07a901581e43231a205aa868e4c7aea22161e99b",
           |    "user":{},
           |    "ref":"update-date"
           |
           |}
         """.stripMargin)

      Commit(json) shouldBe 'defined
   }
}
