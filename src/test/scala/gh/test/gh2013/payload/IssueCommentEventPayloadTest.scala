package gh.test.gh2013.payload

import gh2013.payloads.{IssueCommentEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssueCommentEventPayload extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "issue_id":9601460,
           |    "comment_id":11894342
           |
           |}
         """.stripMargin)

      IssueCommentEventPayload(json) shouldBe 'defined
   }
}
