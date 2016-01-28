package gh.test.gh2011.payload

import gh2011.models.WatchEventPayload
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class WatchEventPayloadTest extends FlatSpec with Matchers
{
   "A valid WatchEventPayload" must "be correctly parsed" in {
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

      WatchEventPayload(json) shouldBe 'defined
   }
}
