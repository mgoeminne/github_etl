package gh.test.gh2011.event

import gh2011.events.PushEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class PushEventTest extends FlatSpec with Matchers
{
   "A valid Push event" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":355634,
           |        "url":"https://api.github.dev/repos/projectblacklight/blacklight",
           |        "name":"projectblacklight/blacklight"
           |    },
           |    "type":"PushEvent",
           |    "org":{
           |        "gravatar_id":"6cb76a4a521c36d96a0583e7c45eaf95",
           |        "id":120516,
           |        "url":"https://api.github.dev/orgs/projectblacklight",
           |        "avatar_url":"https://secure.gravatar.com/avatar/6cb76a4a521c36d96a0583e7c45eaf95?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"projectblacklight"
           |    },
           |    "public":true,
           |    "created_at":"2011-02-12T00:00:00Z",
           |    "payload":{
           |        "shas":[
           |            [
           |                "d3da39ab96a2caecae5d526596a04820c6f848a6",
           |                "bess@stanford.edu",
           |                "We have to stay with cucumber < 0.10 and rspec < 2, otherwise our tests break. I updated the gem requirements to reflect this, so people won't accidentally upgrade to a gem version that's too new when they run rake gems:install",
           |                "Bess Sadler"
           |            ],
           |            [
           |                "898150b7830102cdc171cbd4304b6a783101c3e3",
           |                "bess@stanford.edu",
           |                "Removing unused cruise control tasks. Also, we shouldn't remove the coverage.data file, so we can look at the coverage data over time.",
           |                "Bess Sadler"
           |            ]
           |        ],
           |        "repo":"projectblacklight/blacklight",
           |        "actor":"bess",
           |        "ref":"refs/heads/master",
           |        "size":2,
           |        "head":"898150b7830102cdc171cbd4304b6a783101c3e3",
           |        "actor_gravatar":"887fa2fcd0cf1cbdc6dc43e5524f33f6",
           |        "push_id":24643024
           |    },
           |    "actor":{
           |        "gravatar_id":"887fa2fcd0cf1cbdc6dc43e5524f33f6",
           |        "id":65608,
           |        "url":"https://api.github.dev/users/bess",
           |        "avatar_url":"https://secure.gravatar.com/avatar/887fa2fcd0cf1cbdc6dc43e5524f33f6?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"bess"
           |    },
           |    "id":"1127195475"
           |
           |}
         """.stripMargin)

      gh2011.parser(PushEventParser)(json).isDefined shouldBe true
   }
}
