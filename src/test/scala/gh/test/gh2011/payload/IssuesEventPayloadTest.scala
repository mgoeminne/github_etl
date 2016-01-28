package gh.test.gh2011.payload


import gh2011.models.IssuesEventPayload
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class IssuesEventPayloadTest extends FlatSpec with Matchers
{
   "A valid IssuesEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "number":3,
           |    "repo":"pangratz/netbeans-couchapp",
           |    "actor":"pangratz",
           |    "issue":594121,
           |    "actor_gravatar":"5a153a0262f2f70fc44ea979daca0ce6",
           |    "action":"opened"
           |
           |}
         """.stripMargin)

      IssuesEventPayload(json) shouldBe 'defined
   }
}
