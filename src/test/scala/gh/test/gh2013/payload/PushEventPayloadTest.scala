package gh.test.gh2013.payload

import gh2013.payloads.{PushEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PushEventPayloadTest extends FlatSpec with Matchers
{
   "A valid PushEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "size":3,
           |    "shas":[
           |        [
           |            "d55c296838fefaee5e7b60f2da75d47581d8c84c",
           |            "hamidreza.s@gmail.com",
           |            "Version 0.1.14.10.6 - Modifying date for Order Controller, but still it needs some modification",
           |            "Hamidrezas",
           |            true
           |        ],
           |        [
           |            "87820f8fcb721898b2b8b6fbc10fac0d9bd2fc8f",
           |            "hamidreza.s@gmail.com",
           |            "Merge branch 'experiment' of https://github.com/hamidreza-s/MeloBit into experiment",
           |            "Hamidrezas",
           |            true
           |        ],
           |        [
           |            "3a0288cc0cb12a9d70b8ccc8de5debd347a0f085",
           |            "hamidreza.s@gmail.com",
           |            "Version 0.1.14.10.8 (exp.) - Correct order time to store and show timestamp",
           |            "Hamidrezas",
           |            true
           |        ]
           |    ],
           |    "ref":"refs/heads/experiment",
           |    "head":"3a0288cc0cb12a9d70b8ccc8de5debd347a0f085"
           |
           |}
         """.stripMargin)

      PushEventPayload(json) shouldBe 'defined
   }

   "An other valid PushEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "size":1,
           |    "shas":[
           |        [
           |            "1646b4d31ef20661f7d9335c3634ee9f00aff82f",
           |            "wolmhp@gmail.com",
           |            "移植老代码到可用",
           |            "wolf_m",
           |            true
           |        ]
           |    ],
           |    "ref":"refs/heads/dev",
           |    "head":"1646b4d31ef20661f7d9335c3634ee9f00aff82f"
           |
           |}
         """.stripMargin)

      PushEventPayload(json) shouldBe 'defined
   }
}
