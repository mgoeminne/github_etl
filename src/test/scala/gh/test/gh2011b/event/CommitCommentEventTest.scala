package gh.test.gh2011b.event

import gh2011b.events.{CommitCommentEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CommitCommentEventTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1771097,
           |        "url":"https://api.github.dev/repos/Addict7/YANE",
           |        "name":"Addict7/YANE"
           |    },
           |    "type":"CommitCommentEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T10:40:27Z",
           |    "payload":{
           |        "comment_id":398995,
           |        "commit":"5c91490e82c517df90bb1566a65edb601220ec02"
           |    },
           |    "actor":{
           |        "gravatar_id":"b35bb018ea03ebb9c5984d0afa8d5ddd",
           |        "id":621690,
           |        "url":"https://api.github.dev/users/Addict7",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b35bb018ea03ebb9c5984d0afa8d5ddd?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"Addict7"
           |    },
           |    "id":"1470661729"
           |
           |}
         """.stripMargin)

      gh2011b.parser(CommitCommentEventParser)(json) shouldBe 'defined
   }
}
