package gh.test.gh3

import gh3.models.GH3PullRequestComment
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GH3PullRequestForReviewCommentCommentTest extends FlatSpec with Matchers
{
   "A valid GH3PullRequestComment" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "url":"https://api.github.com/repos/baxterthehacker/public-repo/pulls/comments/29724692",
           |    "id":29724692,
           |    "diff_hunk":"@@ -1 +1 @@\n-# public-repo",
           |    "path":"README.md",
           |    "position":1,
           |    "original_position":1,
           |    "commit_id":"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c",
           |    "original_commit_id":"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c",
           |    "user":{
           |        "login":"baxterthehacker",
           |        "id":6752317,
           |        "avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3",
           |        "gravatar_id":"",
           |        "url":"https://api.github.com/users/baxterthehacker",
           |        "html_url":"https://github.com/baxterthehacker",
           |        "followers_url":"https://api.github.com/users/baxterthehacker/followers",
           |        "following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}",
           |        "gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}",
           |        "starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}",
           |        "subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions",
           |        "organizations_url":"https://api.github.com/users/baxterthehacker/orgs",
           |        "repos_url":"https://api.github.com/users/baxterthehacker/repos",
           |        "events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}",
           |        "received_events_url":"https://api.github.com/users/baxterthehacker/received_events",
           |        "type":"User",
           |        "site_admin":false
           |    },
           |    "body":"Maybe you should use more emojji on this line.",
           |    "created_at":"2015-05-05T23:40:27Z",
           |    "updated_at":"2015-05-05T23:40:27Z",
           |    "html_url":"https://github.com/baxterthehacker/public-repo/pull/1#discussion_r29724692",
           |    "pull_request_url":"https://api.github.com/repos/baxterthehacker/public-repo/pulls/1",
           |    "_links":{
           |        "self":{
           |            "href":"https://api.github.com/repos/baxterthehacker/public-repo/pulls/comments/29724692"
           |        },
           |        "html":{
           |            "href":"https://github.com/baxterthehacker/public-repo/pull/1#discussion_r29724692"
           |        },
           |        "pull_request":{
           |            "href":"https://api.github.com/repos/baxterthehacker/public-repo/pulls/1"
           |        }
           |    }
           |
           |}
         """.stripMargin)

      GH3PullRequestComment(json).isDefined shouldBe true
   }
}
