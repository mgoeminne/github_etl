package gh.test.gh2013.payload

import gh2013.payloads.{FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class FollowEventPayloadTest extends FlatSpec with Matchers
{
   "A valid FolowEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "target":{
           |        "id":3,
           |        "login":"pjhyett",
           |        "gravatar_id":"947c333c75de1dc54a711a400d575c8c",
           |        "repos":15,
           |        "followers":4766
           |    }
           |
           |}
         """.stripMargin)

      FollowEventPayload(json) shouldBe 'defined
   }
}
