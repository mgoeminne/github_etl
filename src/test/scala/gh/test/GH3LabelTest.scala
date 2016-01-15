package gh.test

import gh3.{GH3Label}
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

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
