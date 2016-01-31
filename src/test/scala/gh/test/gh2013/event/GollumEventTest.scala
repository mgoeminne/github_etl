package gh.test.gh2013.event

import gh2013.events.{GollumEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class GollumEventTest extends FlatSpec with Matchers
{
   "A valid GollumEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "actor":"hudec",
           |    "public":true,
           |    "created_at":"2013-01-01T01:37:00-08:00",
           |    "type":"GollumEvent",
           |    "payload":{
           |        "pages":[
           |            {
           |                "title":"Home",
           |                "action":"edited",
           |                "html_url":"https://github.com/hudec/sql-processor/wiki/Home",
           |                "page_name":"Home",
           |                "sha":"b5cfd5f62ef7f76abc82495f5e9d3d146b6d7a4d",
           |                "summary":null
           |            }
           |        ]
           |    },
           |    "repository":{
           |        "watchers":8,
           |        "has_wiki":true,
           |        "owner":"hudec",
           |        "created_at":"2011-04-09T09:55:26-07:00",
           |        "homepage":"",
           |        "stargazers":8,
           |        "open_issues":6,
           |        "pushed_at":"2013-01-01T01:26:32-08:00",
           |        "url":"https://github.com/hudec/sql-processor",
           |        "description":"The SQL Processor is an engine producing the ANSI SQL statements and providing their execution without the necessity to write Java plumbing code related to the ORM or JDBC API.",
           |        "forks":1,
           |        "has_issues":true,
           |        "fork":false,
           |        "size":728,
           |        "has_downloads":true,
           |        "name":"sql-processor",
           |        "language":"Java",
           |        "id":1592013,
           |        "private":false
           |    },
           |
           |    "actor_attributes":{
           |        "blog":"http://www.linkedin.com/pub/vladim%C3%ADr-hudec/17/477/11",
           |        "login":"hudec",
           |        "location":"Prague",
           |        "gravatar_id":"5bbd09833ad88520dd73b3dbd7cc07aa",
           |        "type":"User",
           |        "name":"Vladimír Hudec",
           |        "email":"Vladimir.Hudec@gmail.com"
           |    },
           |    "url":"https://github.com/hudec/sql-processor/wiki/Home"
           |
           |}
         """.stripMargin)

      gh2013.parser(GollumEventParser)(json) shouldBe 'defined
   }


   "Another valid GollumEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"firepick1",
           |    "public":true,
           |    "type":"GollumEvent",
           |    "url":"https://github.com/firepick1/FirePick/wiki/Inventables",
           |    "repository":{
           |        "watchers":0,
           |        "owner":"firepick1",
           |        "created_at":"2012-12-31T20:46:53-08:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "pushed_at":"2012-12-31T20:46:53-08:00",
           |        "url":"https://github.com/firepick1/FirePick",
           |        "description":"www.firepick.org GitHub ",
           |        "forks":0,
           |        "fork":false,
           |        "size":0,
           |        "name":"FirePick",
           |        "id":7393229,
           |        "private":false,
           |        "has_downloads":true
           |    },
           |    "actor_attributes":{
           |        "gravatar_id":"268127beb163e9ba4a6c17975f30d0f0",
           |        "login":"firepick1",
           |        "type":"User"
           |    },
           |    "payload":{
           |        "pages":[
           |            {
           |                "title":"Inventables",
           |                "summary":null,
           |                "sha":"26e67c124d06ff4c030e84007efb8885b6bd6879",
           |                "page_name":"Inventables",
           |                "html_url":"https://github.com/firepick1/FirePick/wiki/Inventables",
           |                "action":"created"
           |            }
           |        ]
           |    },
           |    "created_at":"2013-01-01T00:14:49-08:00"
           |
           |}
         """.stripMargin)

      gh2013.parser(GollumEventParser)(json) shouldBe 'defined
   }

}
