package gh.test.gh2013.payload

import gh2013.payloads.{MemberEventPayload, PullRequestEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MemberEventPayloadTest extends FlatSpec with Matchers
{
   "A valid MemberEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "action":"added",
           |    "member":{
           |        "url":"https://api.github.com/users/apphb",
           |        "repos_url":"https://api.github.com/users/apphb/repos",
           |        "followers_url":"https://api.github.com/users/apphb/followers",
           |        "id":631394,
           |        "starred_url":"https://api.github.com/users/apphb/starred{/owner}{/repo}",
           |        "login":"apphb",
           |        "type":"User",
           |        "received_events_url":"https://api.github.com/users/apphb/received_events",
           |        "gists_url":"https://api.github.com/users/apphb/gists{/gist_id}",
           |        "subscriptions_url":"https://api.github.com/users/apphb/subscriptions",
           |        "events_url":"https://api.github.com/users/apphb/events{/privacy}",
           |        "following_url":"https://api.github.com/users/apphb/following",
           |        "avatar_url":"https://secure.gravatar.com/avatar/03ac88c837ebf7761b39f2afbbae7cdf?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "gravatar_id":"03ac88c837ebf7761b39f2afbbae7cdf",
           |        "organizations_url":"https://api.github.com/users/apphb/orgs"
           |    }
           |
           |}
         """.stripMargin)

      MemberEventPayload(json) shouldBe 'defined
   }
}
