package gh.test.gh2013.payload

import gh2013.payloads.{GollumEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GollumEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GollumEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "pages":[
           |        {
           |            "title":"Home",
           |            "action":"edited",
           |            "html_url":"https://github.com/hudec/sql-processor/wiki/Home",
           |            "page_name":"Home",
           |            "sha":"b5cfd5f62ef7f76abc82495f5e9d3d146b6d7a4d",
           |            "summary":null
           |        }
           |    ]
           |
           |}
         """.stripMargin)

      GollumEventPayload(json) shouldBe 'defined
   }

   "An other valid GollumEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "pages":[
           |        {
           |            "title":"Inventables",
           |            "summary":null,
           |            "sha":"26e67c124d06ff4c030e84007efb8885b6bd6879",
           |            "page_name":"Inventables",
           |            "html_url":"https://github.com/firepick1/FirePick/wiki/Inventables",
           |            "action":"created"
           |        }
           |    ]
           |
           |}
         """.stripMargin)

      GollumEventPayload(json) shouldBe 'defined
   }
}
