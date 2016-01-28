package gh.test.gh2011

import gh2011.models.PullRequest
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._



class PullRequestTest extends FlatSpec with Matchers
{
   "A valid PullRequest" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "title":"Promptmemes",
           |    "number":1,
           |    "commits":1,
           |    "deletions":2,
           |    "id":71911,
           |    "issue_id":593561,
           |    "additions":2
           |
           |}
         """.stripMargin)

      PullRequest(json) shouldBe 'defined
   }
}
