package gh.test.gh2013.event

import gh2013.events.{CreateEventParser, FollowEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class CreateEventTest extends FlatSpec with Matchers
{
   "A valid CreateEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repository":{
           |        "watchers":0,
           |        "owner":"tiltshiftfocus",
           |        "created_at":"2013-01-01T00:14:58-08:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "pushed_at":"2013-01-01T00:20:42-08:00",
           |        "url":"https://github.com/tiltshiftfocus/device_huawei_u8860",
           |        "description":"device tree u8860",
           |        "forks":0,
           |        "has_downloads":true,
           |        "fork":false,
           |        "size":30632,
           |        "name":"device_huawei_u8860",
           |        "has_issues":true,
           |        "language":"C",
           |        "id":7394092,
           |        "private":false,
           |        "has_wiki":true
           |    },
           |    "payload":{
           |        "ref":"master",
           |        "description":"device tree u8860",
           |        "ref_type":"branch",
           |        "master_branch":"master"
           |    },
           |    "actor":"tiltshiftfocus",
           |    "type":"CreateEvent",
           |    "created_at":"2013-01-01T00:20:46-08:00",
           |    "public":true,
           |    "actor_attributes":{
           |        "login":"tiltshiftfocus",
           |        "type":"User",
           |        "gravatar_id":"3bacd6e96490717be5fc98b7c072373f"
           |    },
           |    "url":"https://github.com/tiltshiftfocus/device_huawei_u8860/compare/master"
           |
           |}
         """.stripMargin)

      gh2013.parser(CreateEventParser)(json) shouldBe 'defined
   }
}
