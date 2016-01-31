package gh.test.gh2013.payload

import gh2013.payloads.{GistEventPayload, GollumEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GistEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GistEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "desc":"Ualug org aggregate feed",
           |    "name":"gist: 3083036",
           |    "id":3083036,
           |    "url":"https://gist.github.com/3083036",
           |    "action":"update"
           |
           |}
         """.stripMargin)

      GistEventPayload(json) shouldBe 'defined
   }
}
