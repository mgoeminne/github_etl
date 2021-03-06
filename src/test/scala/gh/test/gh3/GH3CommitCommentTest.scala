package gh.test.gh3

import gh3.models.GH3CommitComment
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GH3CommitCommentTest extends FlatSpec with Matchers
{
   "A valid comment" should "be correctly parsed" in {
      val json = parse(
         """
           |{
           |    "url": "https://api.github.com/repos/baxterthehacker/public-repo/comments/11056394",
           |    "html_url": "https://github.com/baxterthehacker/public-repo/commit/9049f1265b7d61be4a8904a9a27120d2064dab3b#commitcomment-11056394",
           |    "id": 11056394,
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
           |    "position": null,
           |    "line": null,
           |    "path": null,
           |    "commit_id": "9049f1265b7d61be4a8904a9a27120d2064dab3b",
           |    "created_at": "2015-05-05T23:40:29Z",
           |    "updated_at": "2015-05-05T23:40:29Z",
           |    "body": "This is a really good change! :+1:"
           |  }
         """.stripMargin)

      GH3CommitComment(json).isDefined shouldBe true
   }
}
