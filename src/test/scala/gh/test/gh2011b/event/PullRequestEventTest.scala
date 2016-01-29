package gh.test.gh2011b.event

import gh2011b.events.{PullRequestEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PullRequestEventTest extends FlatSpec with Matchers
{
   "A valid PullRequestEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1798622,
           |        "url":"https://api.github.dev/repos/roytomeij/roytomeij.com",
           |        "name":"roytomeij/roytomeij.com"
           |    },
           |    "type":"PullRequestEvent",
           |    "public":true,
           |    "created_at":"2011-05-26T14:34:09Z",
           |    "payload":{
           |        "number":1,
           |        "pull_request":{
           |            "title":"Use this to have working changes.yaml (solves your updated_at problem and",
           |            "number":1,
           |            "commits":1,
           |            "deletions":5,
           |            "id":160762,
           |            "issue_id":958598,
           |            "additions":5
           |        },
           |        "action":"closed"
           |    },
           |    "actor":{
           |        "gravatar_id":"c7c016bb64e49709c083c9cf25d39d8c",
           |        "id":99994,
           |        "url":"https://api.github.dev/users/roytomeij",
           |        "avatar_url":"https://secure.gravatar.com/avatar/c7c016bb64e49709c083c9cf25d39d8c?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"roytomeij"
           |    },
           |    "id":"1470848450"
           |
           |}
         """.stripMargin)

      gh2011b.parser(PullRequestEventParser)(json) shouldBe 'defined
   }
}
