package gh.test.gh2011b.event

import gh2011b.events.{FollowEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class FollowEventTest extends FlatSpec with Matchers
{
   "A valid FollowEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"FollowEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T21:42:08Z",
           |    "payload":{
           |        "target":{
           |            "gravatar_id":"9055b6c1d07708555ec584d03c387f15",
           |            "id":41087,
           |            "repos":80,
           |            "followers":626,
           |            "login":"pkrumins"
           |        }
           |    },
           |    "actor":{
           |        "gravatar_id":"2f91c1e53ad84adf96c8bd9da146ab5e",
           |        "id":808673,
           |        "url":"https://api.github.dev/users/willhunting",
           |        "avatar_url":"https://secure.gravatar.com/avatar/2f91c1e53ad84adf96c8bd9da146ab5e?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"willhunting"
           |    },
           |    "id":"1470752685"
           |
           |}
         """.stripMargin)

      gh2011b.parser(FollowEventParser)(json) shouldBe 'defined
   }
}
