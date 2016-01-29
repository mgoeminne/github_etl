package gh.test.gh2011b.event

import gh2011b.events.PublicEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PublicEventTest extends FlatSpec with Matchers
{
   "A valid PublicEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |    "repo":{
           |        "id":365446,
           |        "url":"https://api.github.dev/repos/jsz/Druid-Quest",
           |        "name":"jsz/Druid-Quest"
           |    },
           |    "type":"PublicEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T07:17:52Z",
           |    "payload":{
           |    },
           |    "actor":{
           |        "gravatar_id":"a1fd708de442807e15a356cc8127d9af",
           |        "id":38862,
           |        "url":"https://api.github.dev/users/jsz",
           |        "avatar_url":"https://secure.gravatar.com/avatar/a1fd708de442807e15a356cc8127d9af?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"jsz"
           |    },
           |    "id":"1470642908"
           |
           |}
         """.stripMargin)

      gh2011b.parser(PublicEventParser)(json) shouldBe 'defined
   }
}
