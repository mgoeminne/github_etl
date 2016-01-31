package gh.test.gh2013.payload

import gh2013.payloads.{DownloadEventPayload, FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class DownloadEventPayloadTest extends FlatSpec with Matchers
{
   "A valid DownloadEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "url":"https://github.com/downloads/cyrille-leclerc/jmxexporter/jmxexporter-1.0.0-SNAPSHOT.jar",
           |    "id":391996
           |}
         """.stripMargin)

      DownloadEventPayload(json) shouldBe 'defined
   }
}
