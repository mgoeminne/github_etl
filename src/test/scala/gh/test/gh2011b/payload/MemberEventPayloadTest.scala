package gh.test.gh2011b.payload

import gh2011b.models.MemberEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MemberEventPayloadTest extends FlatSpec with Matchers
{
   "A valid MemberEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "member":{
           |        "gravatar_id":"ae1002039601636b298efc5cb0e14121",
           |        "id":807289,
           |        "login":"psychonaut"
           |    },
           |    "action":"added"
           |
           |}
         """.stripMargin)

      MemberEventPayload(json) shouldBe 'defined
   }
}
