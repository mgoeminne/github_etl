package gh.test.gh2011.event

import gh2011.events.IssueCommentEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class IssueCommentEventTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":943149,
           |        "url":"https://api.github.dev/repos/mbostock/d3",
           |        "name":"mbostock/d3"
           |    },
           |    "type":"IssueCommentEvent",
           |    "public":true,
           |    "created_at":"2011-04-08T18:43:06Z",
           |    "payload":{
           |        "repo":"mbostock/d3",
           |        "actor":"jasondavies",
           |        "issue_id":739022,
           |        "comment_id":975096,
           |        "actor_gravatar":"f9dd9f4c2b8d081b67fe34769e24808e"
           |    },
           |    "actor":{
           |        "gravatar_id":"f9dd9f4c2b8d081b67fe34769e24808e",
           |        "id":31223,
           |        "url":"https://api.github.dev/users/jasondavies",
           |        "avatar_url":"https://secure.gravatar.com/avatar/f9dd9f4c2b8d081b67fe34769e24808e?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"jasondavies"
           |    },
           |    "id":"1240078187"
           |
           |}
         """.stripMargin)

      gh2011.parser(IssueCommentEventParser)(json)shouldBe 'defined
   }

}
