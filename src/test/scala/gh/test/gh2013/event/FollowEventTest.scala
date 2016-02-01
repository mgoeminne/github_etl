package gh.test.gh2013.event

import gh2013.events.FollowEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class FollowEventTest extends FlatSpec with Matchers
{
   "A valid FollowEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"kelsonzhao",
           |    "public":true,
           |    "created_at":"2013-01-01T00:00:48-08:00",
           |    "type":"FollowEvent",
           |    "payload":{
           |        "target":{
           |            "id":3,
           |            "login":"pjhyett",
           |            "gravatar_id":"947c333c75de1dc54a711a400d575c8c",
           |            "repos":15,
           |            "followers":4766
           |        }
           |    },
           |    "actor_attributes":{
           |        "login":"kelsonzhao",
           |        "location":"China",
           |        "gravatar_id":"dc5cd1cacc3b8d0a063cccd48f1a146d",
           |        "type":"User",
           |        "name":"Kelson",
           |        "company":"hw",
           |        "email":"kelson.3k@gmail.com"
           |    },
           |    "url":"https://github.com/pjhyett"
           |
           |}
         """.stripMargin)

      FollowEventParser.parse(json) shouldBe 'defined
   }


}
