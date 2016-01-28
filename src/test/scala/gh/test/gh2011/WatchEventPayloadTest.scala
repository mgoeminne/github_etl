package gh.test.gh2011

import gh2011.models.WatchEventPayload
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._


class WatchEventPayloadTest extends FlatSpec with Matchers
{
   "A valid WatchEventPayload" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"jruby/using_jruby",
           |    "actor":"fbehrens",
           |    "actor_gravatar":"07426bc321f9f519e7545e650c6cbe3b",
           |    "action":"started"
           |
           |}
         """.stripMargin)

      WatchEventPayload(json).isDefined shouldBe true
   }
}
