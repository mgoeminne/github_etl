package gh.test.gh2013.model

import gh2013.models.EventBody
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class EventBodyTest extends FlatSpec with Matchers
{
   "A valid EventBody" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"moinmoin",
           |    "public":true,
           |    "type":"IssuesEvent",
           |    "url":"https://github.com/moinmoin/wso2registry-extensions/issues/2",
           |    "repository":{
           |        "watchers":0,
           |        "owner":"moinmoin",
           |        "created_at":"2012-12-12T13:33:49-08:00",
           |        "stargazers":0,
           |        "open_issues":1,
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "pushed_at":"2012-12-31T11:44:52-08:00",
           |        "url":"https://github.com/moinmoin/wso2registry-extensions",
           |        "description":"extensions supporting API management with wso2 governance registry",
           |        "forks":0,
           |        "fork":false,
           |        "size":212,
           |        "name":"wso2registry-extensions",
           |        "language":"Java",
           |        "id":7138004,
           |        "private":false,
           |        "has_downloads":true
           |    },
           |    "actor_attributes":{
           |        "gravatar_id":"e4a14ff01743df644940d8752eafaf9c",
           |        "login":"moinmoin",
           |        "type":"User"
           |    },
           |    "payload":{
           |        "number":2,
           |        "action":"opened",
           |        "issue":9600986
           |    },
           |    "created_at":"2013-01-01T00:00:45-08:00"
           |
           |}
         """.stripMargin)

      EventBody(json) shouldBe 'defined
   }
}
