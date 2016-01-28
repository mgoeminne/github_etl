package gh.test.gh2011.event

import gh2011.events.ForkEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class ForkEventTest extends FlatSpec with Matchers
{
   "A valid ForkEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |    "repo":{
           |        "id":722962,
           |        "url":"https://api.github.dev/repos/RuudBurger/CouchPotato",
           |        "name":"RuudBurger/CouchPotato"
           |    },
           |    "type":"ForkEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T16:43:04Z",
           |    "payload":{
           |        "repo":"RuudBurger/CouchPotato",
           |        "actor":"garlandkr",
           |        "forkee":1359086,
           |        "actor_gravatar":"b5a485cbf36d6bdd97bca019ced32354"
           |    },
           |    "actor":{
           |        "gravatar_id":"b5a485cbf36d6bdd97bca019ced32354",
           |        "id":44636,
           |        "url":"https://api.github.dev/users/garlandkr",
           |        "avatar_url":"https://secure.gravatar.com/avatar/b5a485cbf36d6bdd97bca019ced32354?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"garlandkr"
           |    },
           |    "id":"1128246526"
           |
           |}
         """.stripMargin)

      gh2011.parser(ForkEventParser)(json) shouldBe 'defined
   }
}
