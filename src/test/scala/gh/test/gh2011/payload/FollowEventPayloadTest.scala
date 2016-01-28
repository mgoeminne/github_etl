package gh.test.gh2011.payload


import gh2011.models.{FollowEventPayload, DeleteEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class FollowEventPayloadTest extends FlatSpec with Matchers
{
   "A valid FollowEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "target":{
           |        "gravatar_id":"b50d3f9ed186e43dfcc867571749393c",
           |        "repos":8,
           |        "followers":151,
           |        "login":"joearms"
           |    },
           |    "actor":"mulander",
           |    "actor_gravatar":"ec96450f3351c57eeaea1c9c2599e85d"
           |
           |}
         """.stripMargin)

      FollowEventPayload(json) shouldBe 'defined
   }
}
