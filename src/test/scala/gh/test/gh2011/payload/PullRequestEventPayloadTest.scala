package gh.test.gh2011.payload

import gh2011.models.{PullRequestEventPayload, PushEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class PullRequestEventPayloadTest extends FlatSpec with Matchers
{
   "A valid PullRequestEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "number":1,
           |    "pull_request":{
           |        "title":"Promptmemes",
           |        "number":1,
           |        "commits":1,
           |        "deletions":2,
           |        "id":71911,
           |        "issue_id":593561,
           |        "additions":2
           |    },
           |    "repo":"cesy/otwarchive",
           |    "actor":"Enigel",
           |    "actor_gravatar":"5fe035934cec3e46543db19ea8d2e5e3",
           |    "action":"closed"
           |
           |}
         """.stripMargin)

      PullRequestEventPayload(json) shouldBe 'defined
   }
}
