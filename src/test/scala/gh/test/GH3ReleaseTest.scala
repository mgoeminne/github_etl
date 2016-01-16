package gh.test

import gh3.{GH3Release, GH3Page, GH3Forkee, CommitCommentEvent}
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3ReleaseTest extends FlatSpec with Matchers
{
   "A valid GH3Release" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "url": "https://api.github.com/repos/baxterthehacker/public-repo/releases/1261438",
           |    "assets_url": "https://api.github.com/repos/baxterthehacker/public-repo/releases/1261438/assets",
           |    "upload_url": "https://uploads.github.com/repos/baxterthehacker/public-repo/releases/1261438/assets{?name}",
           |    "html_url": "https://github.com/baxterthehacker/public-repo/releases/tag/0.0.1",
           |    "id": 1261438,
           |    "tag_name": "0.0.1",
           |    "target_commitish": "master",
           |    "name": null,
           |    "draft": false,
           |    "author": {
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
           |    "prerelease": false,
           |    "created_at": "2015-05-05T23:40:12Z",
           |    "published_at": "2015-05-05T23:40:38Z",
           |    "assets": [
           |
           |    ],
           |    "tarball_url": "https://api.github.com/repos/baxterthehacker/public-repo/tarball/0.0.1",
           |    "zipball_url": "https://api.github.com/repos/baxterthehacker/public-repo/zipball/0.0.1",
           |    "body": null
           |  }
         """.stripMargin)

      GH3Release(json).isDefined shouldBe true
   }
}