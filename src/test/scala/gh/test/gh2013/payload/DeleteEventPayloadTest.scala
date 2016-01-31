package gh.test.gh2013.payload

import gh2013.payloads.{DeleteEventPayload, FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class DeleteEventPayloadTest extends FlatSpec with Matchers
{
   "A valid DeleteEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "ref":"cs_event_rmadmin",
           |    "ref_type":"branch"
           |
           |}
         """.stripMargin)

      DeleteEventPayload(json) shouldBe 'defined
   }
}
