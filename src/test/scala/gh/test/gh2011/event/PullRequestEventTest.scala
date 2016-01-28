package gh.test.gh2011.event

import gh2011.events.{PullRequestEventParser, WatchEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class PullRequestEventTest extends FlatSpec with Matchers
{
   "A valid PullRequestEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1339575,
           |        "url":"https://api.github.dev/repos/cesy/otwarchive",
           |        "name":"cesy/otwarchive"
           |    },
           |    "type":"PullRequestEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T16:45:04Z",
           |    "payload":{
           |        "number":1,
           |        "pull_request":{
           |            "title":"Promptmemes",
           |            "number":1,
           |            "commits":1,
           |            "deletions":2,
           |            "id":71911,
           |            "issue_id":593561,
           |            "additions":2
           |        },
           |        "repo":"cesy/otwarchive",
           |        "actor":"Enigel",
           |        "actor_gravatar":"5fe035934cec3e46543db19ea8d2e5e3",
           |        "action":"closed"
           |    },
           |    "actor":{
           |        "gravatar_id":"5fe035934cec3e46543db19ea8d2e5e3",
           |        "id":579522,
           |        "url":"https://api.github.dev/users/CristinaRO",
           |        "avatar_url":"https://secure.gravatar.com/avatar/5fe035934cec3e46543db19ea8d2e5e3?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"CristinaRO"
           |    },
           |    "id":"1128247919"
           |
           |}
         """.stripMargin)

      gh2011.parser(PullRequestEventParser)(json) shouldBe 'defined
   }
}
