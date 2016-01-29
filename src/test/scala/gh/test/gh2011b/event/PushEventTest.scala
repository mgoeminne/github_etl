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
}
