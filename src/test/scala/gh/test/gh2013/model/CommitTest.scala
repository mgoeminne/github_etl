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
           |    "user":{
           |         "events_url":"https://api.github.com/users/tnm/events{/privacy}",
           |         "repos_url":"https://api.github.com/users/tnm/repos",
           |         "url":"https://api.github.com/users/tnm",
           |         "organizations_url":"https://api.github.com/users/tnm/orgs",
           |         "id":126905,
           |         "avatar_url":"https://secure.gravatar.com/avatar/803993dc11765d89aee137f29aa05d3a?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |         "gravatar_id":"803993dc11765d89aee137f29aa05d3a",
           |         "type":"User",
           |         "received_events_url":"https://api.github.com/users/tnm/received_events",
           |         "subscriptions_url":"https://api.github.com/users/tnm/subscriptions",
           |         "starred_url":"https://api.github.com/users/tnm/starred{/owner}{/repo}",
           |         "login":"tnm",
           |         "followers_url":"https://api.github.com/users/tnm/followers",
           |         "following_url":"https://api.github.com/users/tnm/following",
           |         "gists_url":"https://api.github.com/users/tnm/gists{/gist_id}"
           |    },
           |    "ref":"update-date"
           |
           |}
         """.stripMargin)

      Commit(json) shouldBe 'defined
   }

   "An other valid Commit" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |            "user":{
           |                "followers_url":"https://api.github.com/users/apneadiving/followers",
           |                "gravatar_id":"808bec1c640143bd7091888d9edfb2f2",
           |                "id":247583,
           |                "subscriptions_url":"https://api.github.com/users/apneadiving/subscriptions",
           |                "received_events_url":"https://api.github.com/users/apneadiving/received_events",
           |                "following_url":"https://api.github.com/users/apneadiving/following",
           |                "url":"https://api.github.com/users/apneadiving",
           |                "starred_url":"https://api.github.com/users/apneadiving/starred{/owner}{/repo}",
           |                "avatar_url":"https://secure.gravatar.com/avatar/808bec1c640143bd7091888d9edfb2f2?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |                "login":"apneadiving",
           |                "events_url":"https://api.github.com/users/apneadiving/events{/privacy}",
           |                "organizations_url":"https://api.github.com/users/apneadiving/orgs",
           |                "gists_url":"https://api.github.com/users/apneadiving/gists{/gist_id}",
           |                "repos_url":"https://api.github.com/users/apneadiving/repos",
           |                "type":"User"
           |            },
           |            "repo":{
           |                "fork":false,
           |                "contributors_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/contributors",
           |                "archive_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/{archive_format}{/ref}",
           |                "watchers_count":1095,
           |                "clone_url":"https://github.com/apneadiving/Google-Maps-for-Rails.git",
           |                "issue_events_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/issues/events{/number}",
           |                "contents_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/contents/{+path}",
           |                "teams_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/teams",
           |                "downloads_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/downloads",
           |                "collaborators_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/collaborators{/collaborator}",
           |                "updated_at":"2013-01-01T18:25:02Z",
           |                "milestones_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/milestones{/number}",
           |                "git_url":"git://github.com/apneadiving/Google-Maps-for-Rails.git",
           |                "git_commits_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/git/commits{/sha}",
           |                "forks":163,
           |                "subscription_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/subscription",
           |                "language":"JavaScript",
           |                "tags_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/tags{/tag}",
           |                "branches_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/branches{/branch}",
           |                "issue_comment_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/issues/comments/{number}",
           |                "mirror_url":null,
           |                "assignees_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/assignees{/user}",
           |                "issues_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/issues{/number}",
           |                "notifications_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/notifications{?since,all,participating}",
           |                "id":1367656,
           |                "open_issues_count":31,
           |                "labels_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/labels{/name}",
           |                "keys_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/keys{/key_id}",
           |                "forks_count":163,
           |                "private":false,
           |                "html_url":"https://github.com/apneadiving/Google-Maps-for-Rails",
           |                "open_issues":31,
           |                "subscribers_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/subscribers",
           |                "homepage":"https://rubygems.org/gems/gmaps4rails",
           |                "compare_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/compare/{base}...{head}",
           |                "trees_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/git/trees{/sha}",
           |                "name":"Google-Maps-for-Rails",
           |                "url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails",
           |                "merges_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/merges",
           |                "has_downloads":true,
           |                "git_tags_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/git/tags{/sha}",
           |                "comments_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/comments{/number}",
           |                "svn_url":"https://github.com/apneadiving/Google-Maps-for-Rails",
           |                "commits_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/commits{/sha}",
           |                "created_at":"2011-02-15T01:05:14Z",
           |                "statuses_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/statuses/{sha}",
           |                "owner":{
           |                    "followers_url":"https://api.github.com/users/apneadiving/followers",
           |                    "gravatar_id":"808bec1c640143bd7091888d9edfb2f2",
           |                    "id":247583,
           |                    "subscriptions_url":"https://api.github.com/users/apneadiving/subscriptions",
           |                    "received_events_url":"https://api.github.com/users/apneadiving/received_events",
           |                    "following_url":"https://api.github.com/users/apneadiving/following",
           |                    "url":"https://api.github.com/users/apneadiving",
           |                    "starred_url":"https://api.github.com/users/apneadiving/starred{/owner}{/repo}",
           |                    "avatar_url":"https://secure.gravatar.com/avatar/808bec1c640143bd7091888d9edfb2f2?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |                    "login":"apneadiving",
           |                    "events_url":"https://api.github.com/users/apneadiving/events{/privacy}",
           |                    "organizations_url":"https://api.github.com/users/apneadiving/orgs",
           |                    "gists_url":"https://api.github.com/users/apneadiving/gists{/gist_id}",
           |                    "repos_url":"https://api.github.com/users/apneadiving/repos",
           |                    "type":"User"
           |                },
           |                "size":200,
           |                "full_name":"apneadiving/Google-Maps-for-Rails",
           |                "has_wiki":true,
           |                "ssh_url":"git@github.com:apneadiving/Google-Maps-for-Rails.git",
           |                "git_refs_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/git/refs{/sha}",
           |                "hooks_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/hooks",
           |                "events_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/events",
           |                "description":"Enables easy display of items (taken from a Rails 3 model) with Google Map, OpenLayers, Bing or Mapquest. Geocoding + Directions included. Provides much options: markers customization, infowindows, auto-adjusted zoom, polylines, polygons, circles etc... See wiki for full description and examples.",
           |                "pushed_at":"2013-01-01T18:25:02Z",
           |                "stargazers_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/stargazers",
           |                "forks_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/forks",
           |                "has_issues":true,
           |                "languages_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/languages",
           |                "watchers":1095,
           |                "pulls_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/pulls{/number}",
           |                "blobs_url":"https://api.github.com/repos/apneadiving/Google-Maps-for-Rails/git/blobs{/sha}"
           |            },
           |            "label":"apneadiving:master",
           |            "sha":"b76ec946fe205e19191cc716abf55a7d77ae4116",
           |            "ref":"master"
           |        }
         """.stripMargin)

      Commit(json) shouldBe 'defined
   }

   "An third valid Commit" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "label":"Florin65:dos",
           |    "sha":"4c0b2f50ebdc7c46a27af3d39b065f214876386a",
           |    "user":{
           |        "received_events_url":"https://api.github.com/users/Florin65/received_events",
           |        "events_url":"https://api.github.com/users/Florin65/events{/privacy}",
           |        "gravatar_id":"bd730de10dfe9d7032be42e395a1f8ca",
           |        "following_url":"https://api.github.com/users/Florin65/following",
           |        "login":"Florin65",
           |        "starred_url":"https://api.github.com/users/Florin65/starred{/owner}{/repo}",
           |        "repos_url":"https://api.github.com/users/Florin65/repos",
           |        "type":"User",
           |        "id":1948024,
           |        "subscriptions_url":"https://api.github.com/users/Florin65/subscriptions",
           |        "url":"https://api.github.com/users/Florin65",
           |        "organizations_url":"https://api.github.com/users/Florin65/orgs",
           |        "followers_url":"https://api.github.com/users/Florin65/followers",
           |        "avatar_url":"https://secure.gravatar.com/avatar/bd730de10dfe9d7032be42e395a1f8ca?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "gists_url":"https://api.github.com/users/Florin65/gists{/gist_id}"
           |    },
           |    "ref":"dos",
           |    "repo":null
           |
           |}
         """.stripMargin)

      Commit(json) shouldBe 'defined
   }
}
