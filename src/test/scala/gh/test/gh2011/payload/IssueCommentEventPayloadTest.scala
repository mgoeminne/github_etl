package gh.test.gh2011.payload


import gh2011.models.{IssueCommentEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class IssueCommentEventPayloadTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"mbostock/d3",
           |    "actor":"jasondavies",
           |    "issue_id":739022,
           |    "comment_id":975096,
           |    "actor_gravatar":"f9dd9f4c2b8d081b67fe34769e24808e"
           |
           |}
         """.stripMargin)

      IssueCommentEventPayload(json) shouldBe 'defined
   }
}
