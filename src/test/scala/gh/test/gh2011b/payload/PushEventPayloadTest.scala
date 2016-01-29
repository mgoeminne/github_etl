package gh.test.gh2011b.payload

import gh2011b.models.PushEventPayload
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PushEventPayloadTest extends FlatSpec with Matchers
{
   "A valid PushEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |        "shas":[
           |            [
           |                "b4caf7b94ef16acfc34ae1f05557c8c3661c1f96",
           |                "thomas@newtonlabs.org",
           |                "WIP",
           |                "Thomas Newton"
           |            ]
           |        ],
           |        "ref":"refs/heads/master",
           |        "size":1,
           |        "head":"b4caf7b94ef16acfc34ae1f05557c8c3661c1f96",
           |        "push_id":34759990
           |    }
         """.stripMargin)

      PushEventPayload(json) shouldBe 'defined
   }
}
