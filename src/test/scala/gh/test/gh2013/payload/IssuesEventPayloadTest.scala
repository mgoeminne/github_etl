package gh.test.gh2013.payload

import gh2013.payloads.IssuesEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssuesEventPayloadTest extends FlatSpec with Matchers
{
   "A valid IssuesEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "number":2,
           |    "action":"opened",
           |    "issue":9600986
           |
           |}
         """.stripMargin)

      IssuesEventPayload(json) shouldBe 'defined
   }
}
