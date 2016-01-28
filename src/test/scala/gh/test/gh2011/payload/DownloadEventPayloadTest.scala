package gh.test.gh2011.payload


import gh2011.models.{DownloadEventPayload, FollowEventPayload, DeleteEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class DownloadEventPayloadTest extends FlatSpec with Matchers
{
   "A valid DownloadEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "id":77739,
           |    "url":"http://cloud.github.com/downloads/my-flow/ImportList/importlist.mxt"
           |
           |}
         """.stripMargin)

      DownloadEventPayload(json) shouldBe 'defined
   }
}
