package gh.test.gh2011b.event

import gh2011b.events.WatchEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class WatchEventTest extends FlatSpec with Matchers
{
   "A valid WatchEventEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":559095,
           |        "url":"https://api.github.dev/repos/aizatto/git-deploy",
           |        "name":"aizatto/git-deploy"
           |    },
           |    "type":"WatchEvent",
           |    "public":true,
           |    "created_at":"2011-05-26T18:37:24Z",
           |    "payload":{
           |        "action":"started"
           |    },
           |    "actor":{
           |        "gravatar_id":"8a11e4c7cca30452fc20fe677c7edb54",
           |        "id":732543,
           |        "url":"https://api.github.dev/users/craigward",
           |        "avatar_url":"https://secure.gravatar.com/avatar/8a11e4c7cca30452fc20fe677c7edb54?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"craigward"
           |    },
           |    "id":"1470885434"
           |
           |}
         """.stripMargin)

      gh2011b.parser(WatchEventParser)(json) shouldBe 'defined
   }
}
