package gh.test.gh2011b.event

import gh2011b.events.GistEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class GistEventTest extends FlatSpec with Matchers
{
   "A valid GistEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"GistEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T18:58:18Z",
           |    "payload":{
           |        "desc":"",
           |        "name":"gist: 991643",
           |        "id":991643,
           |        "url":"https://gist.github.com/991643",
           |        "action":"update"
           |    },
           |    "actor":{
           |        "gravatar_id":"15505f4513a7f05d16b71bde610827c5",
           |        "id":187817,
           |        "url":"https://api.github.dev/users/mikeobrien",
           |        "avatar_url":"https://secure.gravatar.com/avatar/15505f4513a7f05d16b71bde610827c5?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"mikeobrien"
           |    },
           |    "id":"1470727670"
           |
           |}
         """.stripMargin)

      gh2011b.parser(GistEventParser)(json) shouldBe 'defined
   }
}
