package gh.test.gh2011.payload


import gh2011.models.DeleteEventPayload
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class DeleteEventPayloadTest extends FlatSpec with Matchers
{
   "A valid DeleteEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "ref_type":"tag",
           |    "ref":"dspace-1_2@3766"
           |
           |}
         """.stripMargin)

      DeleteEventPayload(json) shouldBe 'defined
   }
}
