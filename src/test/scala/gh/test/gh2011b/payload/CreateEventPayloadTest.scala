package gh.test.gh2011b.payload

import gh2011b.models.{CreateEventPayload, PushEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CreateEventPayloadTest extends FlatSpec with Matchers
{
   "A valid CreateEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "ref_type":"repository",
           |    "ref":null,
           |    "description":"Extract, Transform, and Load domain specific language for Perl",
           |    "master_branch":"master"
           |
           |}
         """.stripMargin)

      CreateEventPayload(json) shouldBe 'defined
   }
}
