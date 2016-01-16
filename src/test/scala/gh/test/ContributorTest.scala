package gh.test

import gh3.{Contributor, GH3Base}
import org.scalatest.{FlatSpec, Matchers}
import net.liftweb.json._

class ContributorTest extends FlatSpec with Matchers
{
   "A valid Contributor" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |        "name": "baxterthehacker",
           |        "email": "baxterthehacker@users.noreply.github.com",
           |        "username": "baxterthehacker"
           |      }
         """.stripMargin)

      Contributor(json).isDefined shouldBe true
   }
}
