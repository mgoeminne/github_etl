package gh.test.gh2011

import gh2011.models.{FollowEventTarget, Organization}
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._



class FollowEventTargetTest extends FlatSpec with Matchers
{
   "A valid FollowEvent target" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "gravatar_id":"b50d3f9ed186e43dfcc867571749393c",
           |    "repos":8,
           |    "followers":151,
           |    "login":"joearms"
           |
           |}
         """.stripMargin)

      FollowEventTarget(json) shouldBe 'defined
   }
}
