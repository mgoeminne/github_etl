package gh.test.gh2011b.payload

import gh2011b.models.{WatchEventPayload, GollumEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class WatchEventPayloadTest extends FlatSpec with Matchers
{
   "A valid WatchEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "action":"started"
           |
           |}
         """.stripMargin)

      WatchEventPayload(json) shouldBe 'defined
   }
}
