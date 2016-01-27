package gh.test

import gh3.models.GH3Sender
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3SenderTest extends FlatSpec with Matchers
{
   "Valid sender" should "be correctly parsed" in
      {
         val json = parse(
            """
              |{
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
              |    }
            """.stripMargin)
         GH3Sender(json).isDefined shouldBe true
      }


   "An other valid sender" should "be correctly parsed" in
      {
         val json = parse(
            """
              |{
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
              |    }
            """.stripMargin)

         GH3Sender(json).isDefined shouldBe true
      }
}
