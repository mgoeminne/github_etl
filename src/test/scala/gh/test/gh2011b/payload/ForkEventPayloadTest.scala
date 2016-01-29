package gh.test.gh2011b.payload

import gh2011b.models.{ForkEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class ForkEventPayloadTest extends FlatSpec with Matchers
{
   "A valid ForkEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "forkee":{
           |        "name":"lvanderree/django-social-auth",
           |        "public":true,
           |        "id":1809752
           |    }
           |
           |}
         """.stripMargin)

      ForkEventPayload(json) shouldBe 'defined
   }
}
