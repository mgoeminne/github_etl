package gh.test.gh2013.event

import gh2013.events.{DeleteEventParser, FollowEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class DeleteEventTest extends FlatSpec with Matchers
{
   "A valid DeleteEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor_attributes":{
           |        "type":"User",
           |        "login":"dstockto",
           |        "gravatar_id":"344e86a6a011a4289a2f5852661b6b37"
           |    },
           |    "url":"https://github.com/",
           |    "created_at":"2013-01-04T14:30:35-08:00",
           |    "actor":"dstockto",
           |    "payload":{
           |        "ref":"cs_event_rmadmin",
           |        "ref_type":"branch"
           |    },
           |    "repository":{
           |        "owner":"dstockto",
           |        "has_downloads":true,
           |        "created_at":"2011-10-31T13:30:34-07:00",
           |        "homepage":"http://joind.in",
           |        "has_issues":false,
           |        "pushed_at":"2013-01-04T14:30:35-08:00",
           |        "url":"https://github.com/dstockto/joind.in",
           |        "description":"Source code behind the Joind.in website - a community-driven site focused on bringing together the people sharing the knowledge with the ones giving feedback.",
           |        "forks":0,
           |        "has_wiki":true,
           |        "watchers":1,
           |        "fork":true,
           |        "size":616,
           |        "name":"joind.in",
           |        "language":"PHP",
           |        "id":2683429,
           |        "stargazers":1,
           |        "private":false,
           |        "open_issues":0
           |    },
           |    "type":"DeleteEvent",
           |    "public":true
           |
           |}
         """.stripMargin)

      gh2013.parser(DeleteEventParser)(json) shouldBe 'defined
   }
}
