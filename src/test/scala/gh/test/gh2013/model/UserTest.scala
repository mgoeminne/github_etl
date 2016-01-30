package gh.test.gh2013.model

import gh2013.models.{User}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class UserTest extends FlatSpec with Matchers
{
   "A valid User" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "events_url":"https://api.github.com/users/tnm/events{/privacy}",
           |    "repos_url":"https://api.github.com/users/tnm/repos",
           |    "url":"https://api.github.com/users/tnm",
           |    "organizations_url":"https://api.github.com/users/tnm/orgs",
           |    "id":126905,
           |    "avatar_url":"https://secure.gravatar.com/avatar/803993dc11765d89aee137f29aa05d3a?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |    "gravatar_id":"803993dc11765d89aee137f29aa05d3a",
           |    "type":"User",
           |    "received_events_url":"https://api.github.com/users/tnm/received_events",
           |    "subscriptions_url":"https://api.github.com/users/tnm/subscriptions",
           |    "starred_url":"https://api.github.com/users/tnm/starred{/owner}{/repo}",
           |    "login":"tnm",
           |    "followers_url":"https://api.github.com/users/tnm/followers",
           |    "following_url":"https://api.github.com/users/tnm/following",
           |    "gists_url":"https://api.github.com/users/tnm/gists{/gist_id}"
           |
           |}
         """.stripMargin)

      User(json) shouldBe 'defined
   }
}
