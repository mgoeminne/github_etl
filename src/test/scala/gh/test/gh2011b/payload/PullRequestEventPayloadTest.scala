package gh.test.gh2011b.payload

import gh2011b.models.{PullRequestEventPayload, PushEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PullRequestEventPayloadTest extends FlatSpec with Matchers
{
   "A valid PullRequestEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "number":1,
           |    "pull_request":{
           |        "title":"Use this to have working changes.yaml (solves your updated_at problem and",
           |        "number":1,
           |        "commits":1,
           |        "deletions":5,
           |        "id":160762,
           |        "issue_id":958598,
           |        "additions":5
           |    },
           |    "action":"closed"
           |
           |}
         """.stripMargin)

      PullRequestEventPayload(json) shouldBe 'defined
   }

}
