package gh.test.gh2011b.event

import gh2011b.events.ForkApplyEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class ForkApplyEventTest extends FlatSpec with Matchers
{
   "A valid ForkApplyEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1155982,
           |        "url":"https://api.github.dev/repos/scieloorg/Webservices",
           |        "name":"scieloorg/Webservices"
           |    },
           |    "type":"ForkApplyEvent",
           |    "org":{
           |        "gravatar_id":"5720ed377fbe2f84cfe8d6973cfbea01",
           |        "id":505032,
           |        "url":"https://api.github.dev/orgs/scieloorg",
           |        "avatar_url":"https://secure.gravatar.com/avatar/5720ed377fbe2f84cfe8d6973cfbea01?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"scieloorg"
           |    },
           |    "public":true,
           |    "created_at":"2011-05-25T18:06:37Z",
           |    "payload":{
           |        "head":"master",
           |        "after":"159f1b4adf52d31f4dd555badcd7d7013ac22085",
           |        "before":"e7de215469e2db0f12584629666833c4d40a7eba"
           |    },
           |    "actor":{
           |        "gravatar_id":"6d045cbf24eae9c724df552fa8a84b50",
           |        "id":505015,
           |        "url":"https://api.github.dev/users/scielo",
           |        "avatar_url":"https://secure.gravatar.com/avatar/6d045cbf24eae9c724df552fa8a84b50?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"scielo"
           |    },
           |    "id":"1470719939"
           |
           |}
         """.stripMargin)

      gh2011b.parser(ForkApplyEventParser)(json) shouldBe 'defined
   }
}
