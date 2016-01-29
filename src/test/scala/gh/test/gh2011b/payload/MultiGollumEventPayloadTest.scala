package gh.test.gh2011b.payload

import gh2011b.models.MultiGollumEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MultiGollumEventPayloadTest extends FlatSpec with Matchers
{
   "A valid MultiGollumEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "pages":[
           |        {
           |            "title":"Django",
           |            "summary":null,
           |            "sha":"83ad75174a48d21c15c27f4fc66b94106dacd457",
           |            "page_name":"Django",
           |            "action":"edited"
           |        }
           |    ]
           |
           |}
         """.stripMargin)

      MultiGollumEventPayload(json) shouldBe 'defined
   }
}
