package gh.test.gh2011b.payload

import gh2011b.models.{IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssuesEventPayloadTest extends FlatSpec with Matchers
{
   "A valid IssuesEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "number":12,
           |    "issue":959102,
           |    "action":"opened"
           |
           |}
         """.stripMargin)

      IssuesEventPayload(json) shouldBe 'defined
   }

}
