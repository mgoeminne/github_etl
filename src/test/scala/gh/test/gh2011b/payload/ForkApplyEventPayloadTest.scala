package gh.test.gh2011b.payload

import gh2011b.models.{ForkApplyEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class ForkApplyEventPayloadTest extends FlatSpec with Matchers
{
   "A valid ForkApplyEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "head":"master",
           |    "after":"159f1b4adf52d31f4dd555badcd7d7013ac22085",
           |    "before":"e7de215469e2db0f12584629666833c4d40a7eba"
           |
           |}
         """.stripMargin)

      ForkApplyEventPayload(json) shouldBe 'defined
   }
}
