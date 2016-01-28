package gh.test.gh2011.payload

import gh2011.models.{PublicEventPayload, CreateEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class PublicEventPayloadTest extends FlatSpec with Matchers
{
   "A valid Public Event Payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"ImDom/MyTakeOnNode",
           |    "actor":"ImDom",
           |    "actor_gravatar":"ee5c354f4afd8328c070958db77ee056"
           |
           |}
         """.stripMargin)

      PublicEventPayload(json) shouldBe 'defined
   }
}
