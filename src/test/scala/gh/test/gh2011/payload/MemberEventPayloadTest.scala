package gh.test.gh2011.payload

import gh2011.models.{MemberEventPayload, PublicEventPayload, CreateEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class MemberEventPayloadTest extends FlatSpec with Matchers
{
   "A valid MemberEvent Payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"jasonmccampbell/scipy-refactor",
           |    "member":"jwiggins",
           |    "actor":"jasonmccampbell",
           |    "actor_gravatar":"3cbc4b4806d66979d51f865e319a2cbc",
           |    "action":"added"
           |
           |}
         """.stripMargin)

      MemberEventPayload(json) shouldBe 'defined
   }
}
