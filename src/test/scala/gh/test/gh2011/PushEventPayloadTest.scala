package gh.test.gh2011

import gh2011.models.PushEventPayload
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class PushEventPayloadTest extends FlatSpec with Matchers
{
   "A valid Payload" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "shas":[
           |        [
           |            "d3da39ab96a2caecae5d526596a04820c6f848a6",
           |            "bess@stanford.edu",
           |            "We have to stay with cucumber < 0.10 and rspec < 2, otherwise our tests break. I updated the gem requirements to reflect this, so people won't accidentally upgrade to a gem version that's too new when they run rake gems:install",
           |            "Bess Sadler"
           |        ],
           |        [
           |            "898150b7830102cdc171cbd4304b6a783101c3e3",
           |            "bess@stanford.edu",
           |            "Removing unused cruise control tasks. Also, we shouldn't remove the coverage.data file, so we can look at the coverage data over time.",
           |            "Bess Sadler"
           |        ]
           |    ],
           |    "repo":"projectblacklight/blacklight",
           |    "actor":"bess",
           |    "ref":"refs/heads/master",
           |    "size":2,
           |    "head":"898150b7830102cdc171cbd4304b6a783101c3e3",
           |    "actor_gravatar":"887fa2fcd0cf1cbdc6dc43e5524f33f6",
           |    "push_id":24643024
           |
           |}
         """.stripMargin)

      PushEventPayload(json).isDefined shouldBe true
   }
}
