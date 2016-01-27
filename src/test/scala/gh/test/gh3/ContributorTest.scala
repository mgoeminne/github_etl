package gh.test.gh3

import gh3.models.Contributor
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

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
