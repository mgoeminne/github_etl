package gh.test


package gh.test

import gh3.models.GH3DeploymentStatus
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GH3DeploymentStatusTest extends FlatSpec with Matchers
{
   "A valid DeploymentStatus" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692/statuses/1115122",
           |    "id": 1115122,
           |    "state": "success",
           |    "creator": {
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
           |    "description": null,
           |    "target_url": null,
           |    "created_at": "2015-05-05T23:40:39Z",
           |    "updated_at": "2015-05-05T23:40:39Z",
           |    "deployment_url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692",
           |    "repository_url": "https://api.github.com/repos/baxterthehacker/public-repo"
           |  }
         """.stripMargin)

      GH3DeploymentStatus(json).isDefined shouldBe true
   }
}
