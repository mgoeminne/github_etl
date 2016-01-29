package gh.test.gh2011b.event

import gh2011b.events.{MultiGollumEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MultiGollumEventTest extends FlatSpec with Matchers
{
   "A valid MultiGollumEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":668311,
           |        "url":"https://api.github.dev/repos/tlam/Wiki",
           |        "name":"tlam/Wiki"
           |    },
           |    "type":"GollumEvent",
           |    "public":true,
           |    "created_at":"2011-08-06T15:37:10Z",
           |    "payload":{
           |        "pages":[
           |            {
           |                "title":"Django",
           |                "summary":null,
           |                "sha":"83ad75174a48d21c15c27f4fc66b94106dacd457",
           |                "page_name":"Django",
           |                "action":"edited"
           |            }
           |        ]
           |    },
           |    "actor":{
           |        "gravatar_id":"1614f2124df75e3924e2b5472ce5594d",
           |        "id":91275,
           |        "url":"https://api.github.dev/users/tlam",
           |        "avatar_url":"https://secure.gravatar.com/avatar/1614f2124df75e3924e2b5472ce5594d?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"tlam"
           |    },
           |    "id":"1480778417"
           |
           |}
         """.stripMargin)

      gh2011b.parser(MultiGollumEventParser)(json) shouldBe 'defined
   }
}
