package gh.test.gh2013.payload

import gh2013.payloads.{CommitCommentEventPayload, CreateEventPayload, FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CommitCommentEventPayloadTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "comment_id":2370688,
           |    "commit":"29612017f6a84eb02714693738d5031209bfd87a"
           |}
         """.stripMargin)

      CommitCommentEventPayload(json) shouldBe 'defined
   }
}
