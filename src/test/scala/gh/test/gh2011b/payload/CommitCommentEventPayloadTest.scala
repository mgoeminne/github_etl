package gh.test.gh2011b.payload

import gh2011b.models.{CommitCommentEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CommitCommentEventPayloadTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "comment_id":398995,
           |    "commit":"5c91490e82c517df90bb1566a65edb601220ec02"
           |
           |}
         """.stripMargin)

      CommitCommentEventPayload(json) shouldBe 'defined
   }
}
