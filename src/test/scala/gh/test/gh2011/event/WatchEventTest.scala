package gh.test.gh2011.event

import gh2011.events.WatchEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class WatchEventTest extends FlatSpec with Matchers
{
   "A valid WatchEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":760797,
           |        "url":"https://api.github.dev/repos/jruby/using_jruby",
           |        "name":"jruby/using_jruby"
           |    },
           |    "type":"WatchEvent",
           |    "org":{
           |        "gravatar_id":"4f169ebd30ce70024c64ff027828ae94",
           |        "id":55687,
           |        "url":"https://api.github.dev/orgs/jruby",
           |        "avatar_url":"https://secure.gravatar.com/avatar/4f169ebd30ce70024c64ff027828ae94?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "login":"jruby"
           |    },
           |    "public":true,
           |    "created_at":"2011-02-12T17:30:20Z",
           |    "payload":{
           |        "repo":"jruby/using_jruby",
           |        "actor":"fbehrens",
           |        "actor_gravatar":"07426bc321f9f519e7545e650c6cbe3b",
           |        "action":"started"
           |    },
           |    "actor":{
           |        "gravatar_id":"07426bc321f9f519e7545e650c6cbe3b",
           |        "id":13704,
           |        "url":"https://api.github.dev/users/fbehrens",
           |        "avatar_url":"https://secure.gravatar.com/avatar/07426bc321f9f519e7545e650c6cbe3b?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"fbehrens"
           |    },
           |    "id":"1128376088"
           |
           |}
         """.stripMargin)

      gh2011.parser(WatchEventParser)(json).isDefined shouldBe true
   }
}
