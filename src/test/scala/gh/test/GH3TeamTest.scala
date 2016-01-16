package gh.test

import gh3.{GH3Team, GH3Page}
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3TeamTest extends FlatSpec with Matchers
{
   "A valid GH3Team" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "name": "Contractors",
           |    "id": 123456,
           |    "slug": "contractors",
           |    "permission": "admin",
           |    "url": "https://api.github.com/teams/123456",
           |    "members_url": "https://api.github.com/teams/123456/members{/member}",
           |    "repositories_url": "https://api.github.com/teams/123456/repos"
           |  }
         """.stripMargin)

      GH3Team(json).isDefined shouldBe true
   }
}
