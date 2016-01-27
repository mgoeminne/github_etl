package gh.test

import gh3.models.GH3Owner
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3OwnerTest extends FlatSpec with Matchers
{
   "A valid GH3Owner" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "name": "baxterthehacker",
           |    "email": "baxterthehacker@users.noreply.github.com"
           |  }
         """.stripMargin)

      GH3Owner(json).isDefined shouldBe true
   }
}
