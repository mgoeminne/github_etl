package gh.test.gh2013.payload

import gh2013.events.PushEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PushEventTest extends FlatSpec with Matchers
{
   "A valid PushEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "created_at":"2013-01-01T00:05:41-08:00",
           |    "url":"https://github.com/hamidreza-s/MeloBit/compare/3d5e780273...3a0288cc0c",
           |    "actor_attributes":{
           |        "type":"User",
           |        "gravatar_id":"417737b8eb65b6ed729e0c784da9622b",
           |        "login":"hamidreza-s"
           |    },
           |    "payload":{
           |        "size":3,
           |        "shas":[
           |            [
           |                "d55c296838fefaee5e7b60f2da75d47581d8c84c",
           |                "hamidreza.s@gmail.com",
           |                "Version 0.1.14.10.6 - Modifying date for Order Controller, but still it needs some modification",
           |                "Hamidrezas",
           |                true
           |            ],
           |            [
           |                "87820f8fcb721898b2b8b6fbc10fac0d9bd2fc8f",
           |                "hamidreza.s@gmail.com",
           |                "Merge branch 'experiment' of https://github.com/hamidreza-s/MeloBit into experiment",
           |                "Hamidrezas",
           |                true
           |            ],
           |            [
           |                "3a0288cc0cb12a9d70b8ccc8de5debd347a0f085",
           |                "hamidreza.s@gmail.com",
           |                "Version 0.1.14.10.8 (exp.) - Correct order time to store and show timestamp",
           |                "Hamidrezas",
           |                true
           |            ]
           |        ],
           |        "ref":"refs/heads/experiment",
           |        "head":"3a0288cc0cb12a9d70b8ccc8de5debd347a0f085"
           |    },
           |    "type":"PushEvent",
           |    "repository":{
           |        "watchers":0,
           |        "owner":"hamidreza-s",
           |        "created_at":"2012-10-15T13:11:27-07:00",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "has_downloads":true,
           |        "pushed_at":"2013-01-01T00:05:39-08:00",
           |        "url":"https://github.com/hamidreza-s/MeloBit",
           |        "description":"MeloBit is a PHP Content Management System",
           |        "forks":0,
           |        "fork":false,
           |        "size":8180,
           |        "name":"MeloBit",
           |        "has_issues":true,
           |        "has_wiki":true,
           |        "language":"PHP",
           |        "id":6233538,
           |        "private":false
           |    },
           |    "actor":"hamidreza-s",
           |    "public":true
           |
           |}
         """.stripMargin)

      gh2013.parser(PushEventParser)(json) shouldBe 'defined
   }
}
