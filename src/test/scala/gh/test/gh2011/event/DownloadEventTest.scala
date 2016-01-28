package gh.test.gh2011.event

import gh2011.events.DownloadEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class DownloadEventTest extends FlatSpec with Matchers
{
   "A valid DownloadEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "url":"https://api.github.dev/repos//",
           |        "name":"/"
           |    },
           |    "type":"DownloadEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T00:10:24Z",
           |    "payload":{
           |        "id":77739,
           |        "url":"http://cloud.github.com/downloads/my-flow/ImportList/importlist.mxt"
           |    },
           |    "actor":{
           |        "gravatar_id":"581c3b13b0f209b3bb3be992d61f7c10",
           |        "id":315457,
           |        "url":"https://api.github.dev/users/my-flow",
           |        "avatar_url":"https://secure.gravatar.com/avatar/581c3b13b0f209b3bb3be992d61f7c10?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"my-flow"
           |    },
           |    "id":"1127203990"
           |
           |}
         """.stripMargin)

      gh2011.parser(DownloadEventParser)(json) shouldBe 'defined
   }
}
