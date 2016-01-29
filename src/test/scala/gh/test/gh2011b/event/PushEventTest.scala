package gh.test.gh2011b.event

import gh2011b.events.PushEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class PushEventTest extends FlatSpec with Matchers
{
   "A valid PushEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1929423,
           |        "url":"https://api.github.dev/repos/newtonlabs/peat",
           |        "name":"newtonlabs/peat"
           |    },
           |    "type":"PushEvent",
           |    "public":true,
           |    "created_at":"2011-06-23T16:59:44Z",
           |    "payload":{
           |        "shas":[
           |            [
           |                "b4caf7b94ef16acfc34ae1f05557c8c3661c1f96",
           |                "thomas@newtonlabs.org",
           |                "WIP",
           |                "Thomas Newton"
           |            ]
           |        ],
           |        "ref":"refs/heads/master",
           |        "size":1,
           |        "head":"b4caf7b94ef16acfc34ae1f05557c8c3661c1f96",
           |        "push_id":34759990
           |    },
           |    "actor":{
           |        "gravatar_id":"3ba8b54f47eb201929b46803c00643cc",
           |        "id":272654,
           |        "url":"https://api.github.dev/users/newtonlabs",
           |        "avatar_url":"https://secure.gravatar.com/avatar/3ba8b54f47eb201929b46803c00643cc?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"newtonlabs"
           |    },
           |    "id":"1474566806"
           |
           |}
         """.stripMargin)

      gh2011b.parser(PushEventParser)(json) shouldBe 'defined
   }

   "An other valid PushEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1629207,
           |        "url":"https://api.github.dev/repos/dxgriffiths/JS11",
           |        "name":"dxgriffiths/JS11"
           |    },
           |    "type":"PushEvent",
           |    "public":true,
           |    "created_at":"2011-05-26T01:38:51Z",
           |    "payload":{
           |        "shas":[
           |            [
           |                "a49c96e552524491c9e890f368709ab7d3997354",
           |                "dxgriffiths@gmail.com",
           |                ".js file now beautified",
           |                "David Griffiths"
           |            ]
           |        ],
           |        "ref":"refs/heads/master",
           |        "size":1,
           |        "head":"a49c96e552524491c9e890f368709ab7d3997354",
           |        "push_id":32316276
           |    },
           |    "actor":{
           |        "gravatar_id":"d974b01285cbd1d4aca66f1cffd03ce3",
           |        "id":237700,
           |        "url":"https://api.github.dev/users/dxgriffiths",
           |        "avatar_url":"https://secure.gravatar.com/avatar/d974b01285cbd1d4aca66f1cffd03ce3?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"dxgriffiths"
           |    },
           |    "id":"1470778334"
           |
           |}
         """.stripMargin)

      gh2011b.parser(PushEventParser)(json) shouldBe 'defined
   }
}
