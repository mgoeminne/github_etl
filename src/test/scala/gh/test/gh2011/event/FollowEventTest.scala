package gh.test.gh2011.event

import gh2011.events.{FollowEventParser, ForkEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class FollowEventTest extends FlatSpec with Matchers
{
   "A valid FollowEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"FollowEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T00:00:33Z",
           |    "payload":{
           |        "target":{
           |            "gravatar_id":"b50d3f9ed186e43dfcc867571749393c",
           |            "repos":8,
           |            "followers":151,
           |            "login":"joearms"
           |        },
           |        "actor":"mulander",
           |        "actor_gravatar":"ec96450f3351c57eeaea1c9c2599e85d"
           |    },
           |    "actor":{
           |        "gravatar_id":"ec96450f3351c57eeaea1c9c2599e85d",
           |        "id":107247,
           |        "url":"https://api.github.dev/users/mulander",
           |        "avatar_url":"https://secure.gravatar.com/avatar/ec96450f3351c57eeaea1c9c2599e85d?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"mulander"
           |    },
           |    "id":"1127195797"
           |
           |}
         """.stripMargin)

      gh2011.parser(FollowEventParser)(json) shouldBe 'defined
   }
}
