package gh.test.gh2011.event

import gh2011.events.DeleteEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class DeleteEventTest extends FlatSpec with Matchers
{
   "A valid DeleteEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"DeleteEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T01:30:54Z",
           |    "payload":{
           |        "ref_type":"tag",
           |        "ref":"dspace-1_2@3766"
           |    },
           |    "actor":{
           |        "gravatar_id":"849712ee1a7933c833801368dbd21013",
           |        "id":58014,
           |        "url":"https://api.github.dev/users/peterdietz",
           |        "avatar_url":"https://secure.gravatar.com/avatar/849712ee1a7933c833801368dbd21013?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"peterdietz"
           |    },
           |    "id":"1127337450"
           |
           |}
         """.stripMargin)

      gh2011.parser(DeleteEventParser)(json) shouldBe 'defined
   }
}
