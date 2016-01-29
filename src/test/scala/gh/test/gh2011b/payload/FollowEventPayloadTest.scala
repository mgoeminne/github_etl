package gh.test.gh2011b.payload

import gh2011b.models.FollowEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class FollowEventPayloadTest extends FlatSpec with Matchers
{
   "A valid FollowEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "target":{
           |        "gravatar_id":"9055b6c1d07708555ec584d03c387f15",
           |        "id":41087,
           |        "repos":80,
           |        "followers":626,
           |        "login":"pkrumins"
           |    }
           |
           |}
         """.stripMargin)

      FollowEventPayload(json) shouldBe 'defined
   }
}
