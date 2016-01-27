package gh.test

import gh3.models.GH3Organization
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._

class GH3OrganizationTest extends FlatSpec with Matchers
{
   "A valid GH3Organization" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "login": "baxterandthehackers",
           |    "id": 7649605,
           |    "url": "https://api.github.com/orgs/baxterandthehackers",
           |    "repos_url": "https://api.github.com/orgs/baxterandthehackers/repos",
           |    "events_url": "https://api.github.com/orgs/baxterandthehackers/events",
           |    "members_url": "https://api.github.com/orgs/baxterandthehackers/members{/member}",
           |    "public_members_url": "https://api.github.com/orgs/baxterandthehackers/public_members{/member}",
           |    "avatar_url": "https://avatars.githubusercontent.com/u/7649605?v=2"
           |  }
         """.stripMargin)

      GH3Organization(json).isDefined shouldBe true
   }
}
