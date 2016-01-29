package gh.test.gh2011b.event

import gh2011b.events.{IssueCommentEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssueCommentEventTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":759578,
           |        "url":"https://api.github.dev/repos/pyrocms/pyrocms",
           |        "name":"pyrocms/pyrocms"
           |    },
           |    "type":"IssueCommentEvent",
           |    "org":{
           |        "gravatar_id":"dde1c17fb1d9ef3488aa82e0e5db5825",
           |        "id":323921,
           |        "url":"https://api.github.dev/orgs/pyrocms",
           |        "avatar_url":"https://secure.gravatar.com/avatar/dde1c17fb1d9ef3488aa82e0e5db5825?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"pyrocms"
           |    },
           |    "public":true,
           |    "created_at":"2011-05-31T15:13:56Z",
           |    "payload":{
           |        "comment_id":1267663,
           |        "issue_id":963480
           |    },
           |    "actor":{
           |        "gravatar_id":"30fba36b9f7da01255a728b7a19b08db",
           |        "id":322706,
           |        "url":"https://api.github.dev/users/jerel",
           |        "avatar_url":"https://secure.gravatar.com/avatar/30fba36b9f7da01255a728b7a19b08db?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"jerel"
           |    },
           |    "id":"1471403473"
           |
           |}
         """.stripMargin)

      gh2011b.parser(IssueCommentEventParser)(json) shouldBe 'defined
   }
}
