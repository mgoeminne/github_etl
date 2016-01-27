package gh.test.gh2011

import gh2011.models.Organization
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._



class OrganizationTest extends FlatSpec with Matchers
{
   "A valid Organization" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "gravatar_id":"6cb76a4a521c36d96a0583e7c45eaf95",
           |    "id":120516,
           |    "url":"https://api.github.dev/orgs/projectblacklight",
           |    "avatar_url":"https://secure.gravatar.com/avatar/6cb76a4a521c36d96a0583e7c45eaf95?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |    "login":"projectblacklight"
           |
           |}
         """.stripMargin)

      Organization(json).isDefined shouldBe true
   }
}
