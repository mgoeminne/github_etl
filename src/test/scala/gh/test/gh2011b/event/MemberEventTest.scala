package gh.test.gh2011b.event

import gh2011b.events.{MemberEventParser, PullRequestEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class MemberEventTest extends FlatSpec with Matchers
{
   "A valid MemberEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1793022,
           |        "url":"https://api.github.dev/repos/wikiaapps/wikia-trunk",
           |        "name":"wikiaapps/wikia-trunk"
           |    },
           |    "type":"MemberEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T15:13:23Z",
           |    "payload":{
           |        "member":{
           |            "gravatar_id":"ae1002039601636b298efc5cb0e14121",
           |            "id":807289,
           |            "login":"psychonaut"
           |        },
           |        "action":"added"
           |    },
           |    "actor":{
           |        "gravatar_id":"b733dc8a4d69cd6bb42836ff5dc8a455",
           |        "id":786369,
           |        "url":"https://api.github.dev/users/wikiaapps",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b733dc8a4d69cd6bb42836ff5dc8a455?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"wikiaapps"
           |    },
           |    "id":"1470693705"
           |
           |}
         """.stripMargin)

      gh2011b.parser(MemberEventParser)(json) shouldBe 'defined
   }
}
