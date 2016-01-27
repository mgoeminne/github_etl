package gh.test.gh3

import gh3.models.GH3Build
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GH3BuildTest extends FlatSpec with Matchers
{
   "A valid GH3Build" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "url": "https://api.github.com/repos/baxterthehacker/public-repo/pages/builds/15995382",
           |    "status": "built",
           |    "error": {
           |      "message": null
           |    },
           |    "pusher": {
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
           |    "commit": "053b99542c83021d6b202d1a1f5ecd5ef7084e55",
           |    "duration": 3790,
           |    "created_at": "2015-05-05T23:40:13Z",
           |    "updated_at": "2015-05-05T23:40:17Z"
           |  }
         """.stripMargin)

      GH3Build(json).isDefined shouldBe true
   }
}
