package gh.test.gh2011.event

import gh2011.events.{GistEventParser, IssuesEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class GistEventTest extends FlatSpec with Matchers
{
   "A valid GistEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"GistEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T00:30:56Z",
           |    "payload":{
           |        "name":"gist: 823336",
           |        "desc":"",
           |        "actor":"avalanche123",
           |        "url":"https://gist.github.com/823336",
           |        "actor_gravatar":"f000c9b4dd0656f60de1dc9e75f7386c",
           |        "snippet":"<?php\n\n$width = 400;",
           |        "action":"update"
           |    },
           |    "actor":{
           |        "gravatar_id":"f000c9b4dd0656f60de1dc9e75f7386c",
           |        "id":83289,
           |        "url":"https://api.github.dev/users/avalanche123",
           |        "avatar_url":"https://secure.gravatar.com/avatar/f000c9b4dd0656f60de1dc9e75f7386c?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"avalanche123"
           |    },
           |    "id":"1127248961"
           |
           |}
         """.stripMargin)

      gh2011.parser(GistEventParser)(json) shouldBe 'defined
   }
}
