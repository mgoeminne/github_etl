package gh.test.gh2013.event

import gh2013.events.{IssueCommentEventParser, IssuesEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class IssueCommentEventTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "actor":"trevnorris",
           |    "created_at":"2013-01-04T10:41:48-08:00",
           |    "repository":{
           |        "owner":"joyent",
           |        "created_at":"2009-05-27T09:29:46-07:00",
           |        "homepage":"http://nodejs.org/",
           |        "open_issues":494,
           |        "pushed_at":"2013-01-04T10:26:05-08:00",
           |        "url":"https://github.com/joyent/node",
           |        "description":"evented I/O for v8 javascript",
           |        "forks":3046,
           |        "has_downloads":false,
           |        "organization":"joyent",
           |        "watchers":19431,
           |        "fork":false,
           |        "size":61420,
           |        "has_issues":true,
           |        "name":"node",
           |        "stargazers":19431,
           |        "language":"JavaScript",
           |        "id":211666,
           |        "private":false,
           |        "has_wiki":true
           |    },
           |    "public":true,
           |    "payload":{
           |        "issue_id":9601460,
           |        "comment_id":11894342
           |    },
           |    "actor_attributes":{
           |        "location":"California",
           |        "login":"trevnorris",
           |        "company":"Mozilla Corporation",
           |        "blog":"http://blog.trevorjnorris.com/",
           |        "type":"User",
           |        "gravatar_id":"3e440ff4686867b1929ce68684591885",
           |        "name":"Trevor Norris"
           |    },
           |    "type":"IssueCommentEvent",
           |    "url":"https://github.com/joyent/node/issues/4504#issuecomment-11894342"
           |
           |}
         """.stripMargin)

      gh2013.parser(IssueCommentEventParser)(json) shouldBe 'defined
   }
}
