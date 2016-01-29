package gh.test.gh2011b.payload

import gh2011b.models.IssueCommentEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssueCommentEventPayloadTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "comment_id":1267663,
           |    "issue_id":963480
           |
           |}
         """.stripMargin)

      IssueCommentEventPayload(json) shouldBe 'defined
   }
}
