package gh.test.gh2011b.payload

import gh2011b.models.{GollumEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GollumEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GollumEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "title":"Pattern Match Pattern",
           |    "summary":null,
           |    "sha":"4a30c5a648bd701431ac8a9dacdfd2d1cdaf52e3",
           |    "page_name":"Pattern Match Pattern",
           |    "action":"edited"
           |
           |}
         """.stripMargin)

      GollumEventPayload(json) shouldBe 'defined
   }
}
