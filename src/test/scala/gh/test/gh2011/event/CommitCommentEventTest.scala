package gh.test.gh2011.event

import gh2011.events.{CommitCommentEventParser, ForkEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class CommitCommentEventTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1347524,
           |        "url":"https://api.github.dev/repos/rpj/frontprocesscheckr",
           |        "name":"rpj/frontprocesscheckr"
           |    },
           |    "type":"CommitCommentEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T00:01:31Z",
           |    "payload":{
           |        "repo":"rpj/frontprocesscheckr",
           |        "actor":"rpj",
           |        "comment_id":268918,
           |        "actor_gravatar":"778a006884e2b2a5d829596ae6351de1",
           |        "commit":"fb7c0238a794809505d14ea481cfcc91fb34c3a1"
           |    },
           |    "actor":{
           |        "gravatar_id":"778a006884e2b2a5d829596ae6351de1",
           |        "id":5136,
           |        "url":"https://api.github.dev/users/rpj",
           |        "avatar_url":"https://secure.gravatar.com/avatar/778a006884e2b2a5d829596ae6351de1?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"rpj"
           |    },
           |    "id":"1127198352"
           |
           |}
         """.stripMargin)

      gh2011.parser(CommitCommentEventParser)(json) shouldBe 'defined
   }
}
