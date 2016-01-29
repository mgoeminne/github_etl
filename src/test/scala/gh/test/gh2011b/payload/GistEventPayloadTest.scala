package gh.test.gh2011b.payload

import gh2011b.models.GistEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GistEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GistEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "desc":"",
           |    "name":"gist: 991643",
           |    "id":991643,
           |    "url":"https://gist.github.com/991643",
           |    "action":"update"
           |
           |}
         """.stripMargin)

      GistEventPayload(json) shouldBe 'defined
   }
}
