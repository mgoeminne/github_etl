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

   "Another valid PushEvent payload" must "be correctly parsed, too" in {
      val json = parse(
         """
           | {
           |
           |    "shas":[
           |        [
           |            "a49c96e552524491c9e890f368709ab7d3997354",
           |            "dxgriffiths@gmail.com",
           |            ".js file now beautified",
           |            "David Griffiths"
           |        ]
           |    ],
           |    "ref":"refs/heads/master",
           |    "size":1,
           |    "head":"a49c96e552524491c9e890f368709ab7d3997354",
           |    "push_id":32316276
           |
           |}
         """.stripMargin)

      PushEventPayload(json) shouldBe 'defined
   }
}
