package gh.test

import gh3.{GH3Page, GH3Forkee, CommitCommentEvent}
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3PageTest extends FlatSpec with Matchers
{
   "A valid GH3Page" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |      "page_name": "Home",
           |      "title": "Home",
           |      "summary": null,
           |      "action": "created",
           |      "sha": "91ea1bd42aa2ba166b86e8aefe049e9837214e67",
           |      "html_url": "https://github.com/baxterthehacker/public-repo/wiki/Home"
           |    }
         """.stripMargin)

      GH3Page(json).isDefined shouldBe true
   }
}
