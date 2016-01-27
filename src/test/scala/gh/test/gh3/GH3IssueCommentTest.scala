package gh.test.gh3

import gh3.models.GH3IssueComment
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GH3IssueCommentTest extends FlatSpec with Matchers
{
   "A valid issue comment" should "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/comments/99262140",
           |    "html_url": "https://github.com/baxterthehacker/public-repo/issues/2#issuecomment-99262140",
           |    "issue_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/2",
           |    "id": 99262140,
           |    "user": {
           |      "login": "baxterthehacker",
           |      "id": 6752317,
           |      "avatar_url": "https://avatars.githubusercontent.com/u/6752317?v=3",
           |      "gravatar_id": "",
           |      "url": "https://api.github.com/users/baxterthehacker",
           |      "html_url": "https://github.com/baxterthehacker",
           |      "followers_url": "https://api.github.com/users/baxterthehacker/followers",
           |      "following_url": "https://api.github.com/users/baxterthehacker/following{/other_user}",
           |      "gists_url": "https://api.github.com/users/baxterthehacker/gists{/gist_id}",
           |      "starred_url": "https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}",
           |      "subscriptions_url": "https://api.github.com/users/baxterthehacker/subscriptions",
           |      "organizations_url": "https://api.github.com/users/baxterthehacker/orgs",
           |      "repos_url": "https://api.github.com/users/baxterthehacker/repos",
           |      "events_url": "https://api.github.com/users/baxterthehacker/events{/privacy}",
           |      "received_events_url": "https://api.github.com/users/baxterthehacker/received_events",
           |      "type": "User",
           |      "site_admin": false
           |    },
           |    "created_at": "2015-05-05T23:40:28Z",
           |    "updated_at": "2015-05-05T23:40:28Z",
           |    "body": "You are totally right! I'll get this fixed right away."
           |  }
         """.stripMargin)

      GH3IssueComment(json).isDefined shouldBe true
   }
}
