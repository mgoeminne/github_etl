package gh.test.gh2011.payload


import gh2011.models.ForkEventPayload
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class ForkEventPayloadTest extends FlatSpec with Matchers
{
   "A valid ForkEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"RuudBurger/CouchPotato",
           |    "actor":"garlandkr",
           |    "forkee":1359086,
           |    "actor_gravatar":"b5a485cbf36d6bdd97bca019ced32354"
           |}
         """.stripMargin)

      ForkEventPayload(json) shouldBe 'defined
   }
}
