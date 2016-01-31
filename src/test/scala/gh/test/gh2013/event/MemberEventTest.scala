package gh.test.gh2013.payload

import gh2013.events.{MemberEventParser, PublicEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MemberEventTest extends FlatSpec with Matchers
{
   "A valid MemberEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "url":"https://github.com/gamyroland/DoukoureWebSite",
           |    "type":"MemberEvent",
           |    "created_at":"2013-01-01T10:22:31-08:00",
           |    "repository":{
           |        "watchers":0,
           |        "owner":"gamyroland",
           |        "created_at":"2013-01-01T10:21:57-08:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "has_issues":true,
           |        "pushed_at":"2013-01-01T10:21:57-08:00",
           |        "url":"https://github.com/gamyroland/DoukoureWebSite",
           |        "description":"Doukoure web site for programming Java courses",
           |        "forks":0,
           |        "has_downloads":true,
           |        "fork":false,
           |        "size":0,
           |        "name":"DoukoureWebSite",
           |        "id":7397709,
           |        "private":false,
           |        "has_wiki":true
           |    },
           |    "actor_attributes":{
           |        "email":"gamy.wroland@gmail.com",
           |        "login":"gamyroland",
           |        "type":"User",
           |        "name":"GAMY W. Roland",
           |        "gravatar_id":"1965d97b6c6d93fe8352b08062bdf477"
           |    },
           |    "payload":{
           |        "action":"added",
           |        "member":{
           |            "url":"https://api.github.com/users/apphb",
           |            "repos_url":"https://api.github.com/users/apphb/repos",
           |            "followers_url":"https://api.github.com/users/apphb/followers",
           |            "id":631394,
           |            "starred_url":"https://api.github.com/users/apphb/starred{/owner}{/repo}",
           |            "login":"apphb",
           |            "type":"User",
           |            "received_events_url":"https://api.github.com/users/apphb/received_events",
           |            "gists_url":"https://api.github.com/users/apphb/gists{/gist_id}",
           |            "subscriptions_url":"https://api.github.com/users/apphb/subscriptions",
           |            "events_url":"https://api.github.com/users/apphb/events{/privacy}",
           |            "following_url":"https://api.github.com/users/apphb/following",
           |            "avatar_url":"https://secure.gravatar.com/avatar/03ac88c837ebf7761b39f2afbbae7cdf?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |            "gravatar_id":"03ac88c837ebf7761b39f2afbbae7cdf",
           |            "organizations_url":"https://api.github.com/users/apphb/orgs"
           |        }
           |    },
           |    "actor":"gamyroland",
           |    "public":true
           |
           |}
         """.stripMargin)

      gh2013.parser(MemberEventParser)(json) shouldBe 'defined
   }
}
