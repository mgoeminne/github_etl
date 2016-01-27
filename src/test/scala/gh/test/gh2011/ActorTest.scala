package gh.test.gh2011

import gh2011.models.Actor
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._



class ActorTest extends FlatSpec with Matchers
{
   "A valid Avatar" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "gravatar_id":"887fa2fcd0cf1cbdc6dc43e5524f33f6",
           |    "id":65608,
           |    "url":"https://api.github.dev/users/bess",
           |    "avatar_url":"https://secure.gravatar.com/avatar/887fa2fcd0cf1cbdc6dc43e5524f33f6?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |    "login":"bess"
           |
           |}
         """.stripMargin)

      Actor(json).isDefined shouldBe true
   }
}
