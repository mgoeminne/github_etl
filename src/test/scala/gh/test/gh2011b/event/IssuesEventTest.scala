package gh.test.gh2011b.event

import gh2011b.events.{IssuesEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssuesEventTest extends FlatSpec with Matchers
{
   "A valid IssuesEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1804783,
           |        "url":"https://api.github.dev/repos/kazum/sheepdog",
           |        "name":"kazum/sheepdog"
           |    },
           |    "type":"IssuesEvent",
           |    "public":true,
           |    "created_at":"2011-05-26T14:58:17Z",
           |    "payload":{
           |        "number":12,
           |        "issue":959102,
           |        "action":"opened"
           |    },
           |    "actor":{
           |        "gravatar_id":"71d391c020f3e86b9216a9e5eb93de95",
           |        "id":812126,
           |        "url":"https://api.github.dev/users/kazum",
           |        "avatar_url":"https://secure.gravatar.com/avatar/71d391c020f3e86b9216a9e5eb93de95?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"kazum"
           |    },
           |    "id":"1470852280"
           |
           |}
         """.stripMargin)

      gh2011b.parser(IssuesEventParser)(json) shouldBe 'defined
   }
}
