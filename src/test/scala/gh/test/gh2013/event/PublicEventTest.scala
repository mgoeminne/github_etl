package gh.test.gh2013.payload

import gh2013.events.{PublicEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PublicEventTest extends FlatSpec with Matchers
{
   "A valid PublicEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"savvy2020",
           |    "public":true,
           |    "type":"PublicEvent",
           |    "url":"https://github.com/savvy2020/ros-ip",
           |    "repository":{
           |        "watchers":0,
           |        "owner":"savvy2020",
           |        "created_at":"2012-12-19T23:20:12-08:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "pushed_at":"2012-12-19T23:21:48-08:00",
           |        "url":"https://github.com/savvy2020/ros-ip",
           |        "description":"Image processing in ros. Test node",
           |        "forks":0,
           |        "fork":false,
           |        "size":112,
           |        "name":"ros-ip",
           |        "language":"C++",
           |        "id":7253743,
           |        "private":false,
           |        "has_downloads":true
           |    },
           |    "actor_attributes":{
           |        "blog":"www.ee.iitb.ac.in/student/~sksavant",
           |        "gravatar_id":"d2a456a38a7df40fdfa3c91930e6bbc2",
           |        "location":"Mumbai, India",
           |        "login":"savvy2020",
           |        "name":"Savant Krishna",
           |        "type":"User",
           |        "email":"savant.2020@gmail.com"
           |    },
           |    "created_at":"2013-01-01T05:04:57-08:00"
           |
           |}
         """.stripMargin)

      PublicEventParser.parse(json) shouldBe 'defined
   }
}
