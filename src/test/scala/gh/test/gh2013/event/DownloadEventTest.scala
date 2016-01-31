package gh.test.gh2013.event

import gh2013.events.{DownloadEventParser, FollowEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class DownloadEventTest extends FlatSpec with Matchers
{
   "A valid DownloadEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repository":{
           |        "watchers":0,
           |        "owner":"cyrille-leclerc",
           |        "created_at":"2012-12-19T14:13:15-08:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "pushed_at":"2012-12-30T17:21:31-08:00",
           |        "url":"https://github.com/cyrille-leclerc/jmxexporter",
           |        "description":"In process JMX metrics exporter. Inspired by JMXTrans",
           |        "forks":0,
           |        "fork":false,
           |        "size":1859,
           |        "name":"jmxexporter",
           |        "language":"Java",
           |        "id":7248262,
           |        "private":false,
           |        "has_downloads":true
           |    },
           |    "actor_attributes":{
           |        "blog":"http://blog.xebia.fr",
           |        "name":"Cyrille Le Clerc",
           |        "company":"Xebia France",
           |        "email":"cyrille@cyrilleleclerc.com",
           |        "login":"cyrille-leclerc",
           |        "type":"User",
           |        "gravatar_id":"df85cd156eaafa6428647b9dcae51dd7",
           |        "location":"Paris, France"
           |    },
           |    "url":"https://github.com/downloads/cyrille-leclerc/jmxexporter/jmxexporter-1.0.0-SNAPSHOT.jar",
           |    "payload":{
           |        "url":"https://github.com/downloads/cyrille-leclerc/jmxexporter/jmxexporter-1.0.0-SNAPSHOT.jar",
           |        "id":391996
           |    },
           |    "public":true,
           |    "actor":"cyrille-leclerc",
           |    "type":"DownloadEvent",
           |    "created_at":"2013-01-01T12:23:20-08:00"
           |
           |}
         """.stripMargin)

      gh2013.parser(DownloadEventParser)(json) shouldBe 'defined
   }
}
