package gh.test.gh2011b.event

import gh2011b.events.{GollumEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GollumEventTest extends FlatSpec with Matchers
{
   "A valid GollumEventEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":379199,
           |        "url":"https://api.github.dev/repos/tinkerpop/gremlin",
           |        "name":"tinkerpop/gremlin"
           |    },
           |    "type":"GollumEvent",
           |    "org":{
           |        "gravatar_id":"40feb25b7b2632d536ac07ccb0349907",
           |        "id":155806,
           |        "url":"https://api.github.dev/orgs/tinkerpop",
           |        "avatar_url":"https://secure.gravatar.com/avatar/40feb25b7b2632d536ac07ccb0349907?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"tinkerpop"
           |    },
           |    "public":true,
           |    "created_at":"2011-05-27T19:46:23Z",
           |    "payload":{
           |        "title":"Pattern Match Pattern",
           |        "summary":null,
           |        "sha":"4a30c5a648bd701431ac8a9dacdfd2d1cdaf52e3",
           |        "page_name":"Pattern Match Pattern",
           |        "action":"edited"
           |    },
           |    "actor":{
           |        "gravatar_id":"fb12ea6a621399613aae4d692533e067",
           |        "id":148925,
           |        "url":"https://api.github.dev/users/okram",
           |        "avatar_url":"https://secure.gravatar.com/avatar/fb12ea6a621399613aae4d692533e067?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"okram"
           |    },
           |    "id":"1471048106"
           |
           |}
         """.stripMargin)

      gh2011b.parser(GollumEventParser)(json) shouldBe 'defined
   }
}
