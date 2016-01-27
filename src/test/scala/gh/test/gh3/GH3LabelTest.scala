package gh.test.gh3

import gh3.models.GH3Label
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GH3LabelTest extends FlatSpec with Matchers
{
   "A valid GH3Label" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |        "url": "https://api.github.com/repos/baxterthehacker/public-repo/labels/bug",
           |        "name": "bug",
           |        "color": "fc2929"
           | }
         """.stripMargin)

       GH3Label(json).isDefined shouldBe true
   }
}
