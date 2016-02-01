package gh.test.gh2013.payload

import gh2013.payloads.{PublicEventPayload, PullRequestEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PublicEventPayloadTest extends FlatSpec with Matchers
{
   "A valid PublicEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "head":"ef55c21b35e41978ed5aeb0e98632a4e80248e37",
           |    "size":1,
           |    "shas":[
           |        [
           |            "ef55c21b35e41978ed5aeb0e98632a4e80248e37",
           |            "killianjimenez@gmail.com",
           |            "Third",
           |            "killian jimenez lecroc",
           |            true
           |        ]
           |    ],
           |    "ref":"refs/heads/master"
           |
           |}
         """.stripMargin)

      PublicEventPayload(json) shouldBe 'defined
   }
}
