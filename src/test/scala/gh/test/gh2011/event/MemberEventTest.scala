package gh.test.gh2011.event

import gh2011.events.{MemberEventParser, PublicEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class MemberEventTest extends FlatSpec with Matchers
{
   "A valid MemberEvent" must "be correctly parsed" in
      {
         val json = parse(
            """
              | {
              |
              |    "repo":{
              |        "id":985116,
              |        "url":"https://api.github.dev/repos/jasonmccampbell/scipy-refactor",
              |        "name":"jasonmccampbell/scipy-refactor"
              |    },
              |    "type":"MemberEvent",
              |    "public":true,
              |    "created_at":"2011-02-12T00:05:12Z",
              |    "payload":{
              |        "repo":"jasonmccampbell/scipy-refactor",
              |        "member":"jwiggins",
              |        "actor":"jasonmccampbell",
              |        "actor_gravatar":"3cbc4b4806d66979d51f865e319a2cbc",
              |        "action":"added"
              |    },
              |    "actor":{
              |        "gravatar_id":"3cbc4b4806d66979d51f865e319a2cbc",
              |        "id":267494,
              |        "url":"https://api.github.dev/users/jasonmccampbell",
              |        "avatar_url":"https://secure.gravatar.com/avatar/3cbc4b4806d66979d51f865e319a2cbc?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
              |        "login":"jasonmccampbell"
              |    },
              |    "id":"1127200212"
              |
              |}
            """.stripMargin)

         gh2011.parser(MemberEventParser)(json) shouldBe 'defined
      }
}

