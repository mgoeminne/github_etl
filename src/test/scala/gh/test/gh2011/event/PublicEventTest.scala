package gh.test.gh2011.event

import gh2011.events.PublicEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class PublicEventTest extends FlatSpec with Matchers
{
   "A valid PublicEvent" must "be correctly parsed" in
      {
         val json = parse(
            """
           | {
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"PublicEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T16:43:17Z",
           |    "payload":{
           |        "repo":"ImDom/MyTakeOnNode",
           |        "actor":"ImDom",
           |        "actor_gravatar":"ee5c354f4afd8328c070958db77ee056"
           |    },
           |    "actor":{
           |        "gravatar_id":"ee5c354f4afd8328c070958db77ee056",
           |        "id":313966,
           |        "url":"https://api.github.dev/users/ImDom",
           |        "avatar_url":"https://secure.gravatar.com/avatar/ee5c354f4afd8328c070958db77ee056?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"ImDom"
           |    },
           |    "id":"1128246591"
           |
           |}
         """.stripMargin)

         gh2011.parser(PublicEventParser)(json) shouldBe 'defined
   }
}

