package gh.test.gh2013.payload

import gh2013.events.{WatchEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class WatchEventTest extends FlatSpec with Matchers
{
   "A valid WatchEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"ledermann",
           |    "public":true,
           |    "type":"WatchEvent",
           |    "url":"https://github.com/SamSaffron/MiniProfiler",
           |    "repository":{
           |        "watchers":681,
           |        "owner":"SamSaffron",
           |        "created_at":"2011-08-11T19:27:25-07:00",
           |        "homepage":"http://miniprofiler.com",
           |        "stargazers":681,
           |        "open_issues":9,
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "pushed_at":"2012-12-11T14:05:04-08:00",
           |        "url":"https://github.com/SamSaffron/MiniProfiler",
           |        "description":"A simple but effective mini-profiler for ASP.NET MVC, ASP.NET and Ruby.",
           |        "forks":160,
           |        "fork":false,
           |        "size":448,
           |        "name":"MiniProfiler",
           |        "language":"C#",
           |        "id":2194936,
           |        "private":false,
           |        "has_downloads":true
           |    },
           |    "actor_attributes":{
           |        "blog":"http://www.georg-ledermann.de",
           |        "gravatar_id":"8ef34e54174d6947dcb3c3d031a44d83",
           |        "company":"",
           |        "location":"Aachen, Germany",
           |        "login":"ledermann",
           |        "name":"Georg Ledermann",
           |        "type":"User",
           |        "email":"mail@georg-ledermann.de"
           |    },
           |    "payload":{
           |        "action":"started"
           |    },
           |    "created_at":"2013-01-01T01:31:44-08:00"
           |
           |}
         """.stripMargin)

      gh2013.parser(WatchEventParser)(json) shouldBe 'defined
   }
}
