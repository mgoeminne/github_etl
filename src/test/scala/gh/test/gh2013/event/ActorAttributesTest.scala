package gh.test.gh2013.payload

import gh2011c.models.IssueCommentEventPayload
import gh2013.events.ActorAttributes
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class ActorAttributesTest extends FlatSpec with Matchers
{
   "A valid ActorAttributes" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "gravatar_id":"e4a14ff01743df644940d8752eafaf9c",
           |    "login":"moinmoin",
           |    "type":"User"
           |
           |}
         """.stripMargin)

      ActorAttributes(json) shouldBe 'defined
   }
}
