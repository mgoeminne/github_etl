package gh.test.gh2011.payload


import gh2011.models.{ForkApplyEventPayload, ForkEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class ForkApplyEventPayloadTest extends FlatSpec with Matchers
{
   "A valid ForkApplyEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"defunkt/evilbot",
           |    "actor":"defunkt",
           |    "head":"master",
           |    "original":"e09135a577dfcce58ea69607e8d74faa426c739e",
           |    "actor_gravatar":"b8dbb1987e8e5318584865f880036796",
           |    "commit":"56296c4da221b133416a38cd175b42fa0c0dcc92"
           |
           |}
         """.stripMargin)

      ForkApplyEventPayload(json) shouldBe 'defined
   }
}
