package gh.test.gh2011.event

import gh2011.events.{GollumEventParser, GistEventParser, IssuesEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class GollumEventTest extends FlatSpec with Matchers
{
   "A valid GollumEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1146844,
           |        "url":"https://api.github.dev/repos/ninject/ninject.extensions.wf",
           |        "name":"ninject/ninject.extensions.wf"
           |    },
           |    "type":"GollumEvent",
           |    "org":{
           |        "gravatar_id":"b46527233865dd59f195fe0c2115a6e0",
           |        "id":254550,
           |        "url":"https://api.github.dev/orgs/ninject",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b46527233865dd59f195fe0c2115a6e0?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"ninject"
           |    },
           |    "public":true,
           |    "created_at":"2011-02-12T00:00:43Z",
           |    "payload":{
           |        "title":"Home",
           |        "summary":null,
           |        "repo":"ninject/ninject.extensions.wf",
           |        "sha":"3ef341252dc952ffc8985f6329dfcb4e50fef606",
           |        "actor":"ninject",
           |        "page_name":"Home",
           |        "actor_gravatar":"b46527233865dd59f195fe0c2115a6e0",
           |        "action":"created"
           |    },
           |    "actor":{
           |        "gravatar_id":"b46527233865dd59f195fe0c2115a6e0",
           |        "id":254550,
           |        "url":"https://api.github.dev/users/ninject",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b46527233865dd59f195fe0c2115a6e0?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"ninject"
           |    },
           |    "id":"1127195882"
           |
           |}
         """.stripMargin)

      gh2011.parser(GollumEventParser)(json) shouldBe 'defined
   }
}
