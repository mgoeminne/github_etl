package gh.test.gh2013.event

import gh2013.events.{GistEventParser, GollumEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class GistEventTest extends FlatSpec with Matchers
{
   "A valid GistEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"fxsapa",
           |    "public":true,
           |    "type":"GistEvent",
           |    "url":"https://gist.github.com/3083036",
           |    "actor_attributes":{
           |        "gravatar_id":"0a8ee3720698029d17f3838657ecf5d9",
           |        "login":"fxsapa",
           |        "type":"User"
           |    },
           |    "payload":{
           |        "desc":"Ualug org aggregate feed",
           |        "name":"gist: 3083036",
           |        "id":3083036,
           |        "url":"https://gist.github.com/3083036",
           |        "action":"update"
           |    },
           |    "created_at":"2013-01-01T00:47:10-08:00"
           |
           |}
         """.stripMargin)

      GistEventParser.parse(json) shouldBe 'defined
   }
}
