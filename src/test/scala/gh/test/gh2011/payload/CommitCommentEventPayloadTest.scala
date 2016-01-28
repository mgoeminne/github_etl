package gh.test.gh2011.payload

import gh2011.models.{CommitCommentEventPayload, CreateEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class CommitCommentEventPayloadTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent Payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":"rpj/frontprocesscheckr",
           |    "actor":"rpj",
           |    "comment_id":268918,
           |    "actor_gravatar":"778a006884e2b2a5d829596ae6351de1",
           |    "commit":"fb7c0238a794809505d14ea481cfcc91fb34c3a1"
           |
           |}
         """.stripMargin)

      CommitCommentEventPayload(json) shouldBe 'defined
   }
}
