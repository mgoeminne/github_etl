package gh.test.gh2011.event

import gh2011.events.{ForkApplyEventParser, ForkEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class ForkApplyEventTest extends FlatSpec with Matchers
{
   "A valid ForkApplyEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1167457,
           |        "url":"https://api.github.dev/repos/defunkt/evilbot",
           |        "name":"defunkt/evilbot"
           |    },
           |    "type":"ForkApplyEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T01:03:52Z",
           |    "payload":{
           |        "repo":"defunkt/evilbot",
           |        "actor":"defunkt",
           |        "head":"master",
           |        "original":"e09135a577dfcce58ea69607e8d74faa426c739e",
           |        "actor_gravatar":"b8dbb1987e8e5318584865f880036796",
           |        "commit":"56296c4da221b133416a38cd175b42fa0c0dcc92"
           |    },
           |    "actor":{
           |        "gravatar_id":"b8dbb1987e8e5318584865f880036796",
           |        "id":2,
           |        "url":"https://api.github.dev/users/defunkt",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b8dbb1987e8e5318584865f880036796?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"defunkt"
           |    },
           |    "id":"1127289731"
           |
           |}
         """.stripMargin)

      gh2011.parser(ForkApplyEventParser)(json) shouldBe 'defined
   }
}
