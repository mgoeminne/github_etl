package gh.test.gh2011b.event

import gh2011b.events.{CreateEventParser, PushEventParser}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class CreateEventTest extends FlatSpec with Matchers
{
   "A valid CreateEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "repo":{
           |        "id":1796657,
           |        "url":"https://api.github.dev/repos/billious/petl",
           |        "name":"billious/petl"
           |    },
           |    "type":"CreateEvent",
           |    "public":true,
           |    "created_at":"2011-05-25T01:13:27Z",
           |    "payload":{
           |        "ref_type":"repository",
           |        "ref":null,
           |        "description":"Extract, Transform, and Load domain specific language for Perl",
           |        "master_branch":"master"
           |    },
           |    "actor":{
           |        "gravatar_id":"64c14426cabc05ad464adae8aebd7b38",
           |        "id":808758,
           |        "url":"https://api.github.dev/users/billious",
           |        "avatar_url":"https://secure.gravatar.com/avatar/64c14426cabc05ad464adae8aebd7b38?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"billious"
           |    },
           |    "id":"1470617534"
           |
           |}
         """.stripMargin)

      gh2011b.parser(CreateEventParser)(json) shouldBe 'defined
   }
}
