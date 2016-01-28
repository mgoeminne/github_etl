package gh.test.gh2011.event

import gh2011.events.CreateEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class CreateEventTest extends FlatSpec with Matchers
{
   "A valid CreateEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1359157,
           |        "url":"https://api.github.dev/repos/syedhussaini/syed_project_app",
           |        "name":"syedhussaini/syed_project_app"
           |    },
           |    "type":"CreateEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T17:02:34Z",
           |    "payload":{
           |        "name":"syed_project_app",
           |        "object":"repository",
           |        "object_name":null
           |    },
           |    "actor":{
           |        "gravatar_id":"e2da15353f419c8b4a9aa70e2f112071",
           |        "id":597437,
           |        "url":"https://api.github.dev/users/syedhussaini",
           |        "avatar_url":"https://secure.gravatar.com/avatar/e2da15353f419c8b4a9aa70e2f112071?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"syedhussaini"
           |    },
           |    "id":"1128317184"
           |
           |}
         """.stripMargin)

      gh2011.parser(CreateEventParser)(json)shouldBe 'defined
   }

   "An other CreateEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"CreateEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T16:42:38Z",
           |    "payload":{
           |        "name":"sample_app",
           |        "object":"repository",
           |        "object_name":null
           |    },
           |    "actor":{
           |        "url":"https://api.github.dev/users/",
           |        "avatar_url":"https://secure.gravatar.com/avatar/?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png"
           |    },
           |    "id":"1128246449"
           |
           |}
         """.stripMargin)

      gh2011.parser(CreateEventParser)(json) shouldBe 'defined
   }
}
