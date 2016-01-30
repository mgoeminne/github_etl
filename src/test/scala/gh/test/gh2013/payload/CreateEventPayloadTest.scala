package gh.test.gh2013.payload

import gh2013.payloads.{CreateEventPayload, FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CreateEventPayloadTest extends FlatSpec with Matchers
{
   "A valid CreateEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "ref":"master",
           |    "description":"device tree u8860",
           |    "ref_type":"branch",
           |    "master_branch":"master"
           |
           |}
         """.stripMargin)

      CreateEventPayload(json) shouldBe 'defined
   }
}
