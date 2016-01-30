package gh.test.gh2013.event

import gh2013.events.{ForkEventParser, IssuesEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class ForkEventTest extends FlatSpec with Matchers
{
   "A valid ForkEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"BlackStrider",
           |    "public":true,
           |    "created_at":"2013-01-01T01:18:52-08:00",
           |    "type":"ForkEvent",
           |    "payload":{
           |    },
           |    "repository":{
           |        "watchers":378,
           |        "has_wiki":true,
           |        "owner":"ProjectSkyfire",
           |        "created_at":"2011-09-03T09:51:08-07:00",
           |        "homepage":"http://www.projectskyfire.org",
           |        "stargazers":378,
           |        "open_issues":256,
           |        "pushed_at":"2012-12-31T18:16:13-08:00",
           |        "url":"https://github.com/ProjectSkyfire/SkyFireEMU",
           |        "description":"4.0.6a Supported.| Public DB is in downloads section or at: https://github.com/ProjectSkyfire/SkyFireDB",
           |        "forks":197,
           |        "organization":"ProjectSkyfire",
           |        "has_issues":true,
           |        "fork":false,
           |        "size":36918,
           |        "has_downloads":true,
           |        "name":"SkyFireEMU",
           |        "language":"C++",
           |        "id":2319823,
           |        "private":false
           |    },
           |    "actor_attributes":{
           |        "login":"BlackStrider",
           |        "gravatar_id":"3008f7279c720a5961d1caa5f442420f",
           |        "type":"User"
           |    },
           |    "url":"https://github.com/BlackStrider/SkyFireEMU"
           |
           |}
         """.stripMargin)

      gh2013.parser(ForkEventParser)(json) shouldBe 'defined
   }
}
