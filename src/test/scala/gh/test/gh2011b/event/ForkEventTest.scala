package gh.test.gh2011b.event

import gh2011b.events.ForkEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class ForkEventTest extends FlatSpec with Matchers
{
   "A valid ForkEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1060073,
           |        "url":"https://api.github.dev/repos/omab/django-social-auth",
           |        "name":"omab/django-social-auth"
           |    },
           |    "type":"ForkEvent",
           |    "public":true,
           |    "created_at":"2011-05-27T13:30:39Z",
           |    "payload":{
           |        "forkee":{
           |            "name":"lvanderree/django-social-auth",
           |            "public":true,
           |            "id":1809752
           |        }
           |    },
           |    "actor":{
           |        "gravatar_id":"5c220f54bff8d69d02f13b5877039784",
           |        "id":206672,
           |        "url":"https://api.github.dev/users/lvanderree",
           |        "avatar_url":"https://secure.gravatar.com/avatar/5c220f54bff8d69d02f13b5877039784?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"lvanderree"
           |    },
           |    "id":"1470996398"
           |
           |}
         """.stripMargin)

      gh2011b.parser(ForkEventParser)(json) shouldBe 'defined
   }
}
