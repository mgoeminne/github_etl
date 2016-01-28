package gh.test.gh2011.event

import gh2011.events.IssuesEventParser
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}



class IssuesEventTest extends FlatSpec with Matchers
{
   "A valid IssuesEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "repo":{
           |        "id":1359031,
           |        "url":"https://api.github.dev/repos/pangratz/netbeans-couchapp",
           |        "name":"pangratz/netbeans-couchapp"
           |    },
           |    "type":"IssuesEvent",
           |    "public":true,
           |    "created_at":"2011-02-12T16:42:41Z",
           |    "payload":{
           |        "number":3,
           |        "repo":"pangratz/netbeans-couchapp",
           |        "actor":"pangratz",
           |        "issue":594121,
           |        "actor_gravatar":"5a153a0262f2f70fc44ea979daca0ce6",
           |        "action":"opened"
           |    },
           |    "actor":{
           |        "gravatar_id":"3cf2c8a8b86101d861efb7b14938513c",
           |        "id":341877,
           |        "url":"https://api.github.dev/users/pangratz",
           |        "avatar_url":"https://secure.gravatar.com/avatar/3cf2c8a8b86101d861efb7b14938513c?d=http://github.dev%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "login":"pangratz"
           |    },
           |    "id":"1128246492"
           |
           |}
         """.stripMargin)

      gh2011.parser(IssuesEventParser)(json) shouldBe 'defined
   }
}
