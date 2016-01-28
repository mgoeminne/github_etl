package gh.test.gh2011.payload


import gh2011.models.{GollumEventPayload, GistEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GollumEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GollumEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "title":"Home",
           |    "summary":null,
           |    "repo":"ninject/ninject.extensions.wf",
           |    "sha":"3ef341252dc952ffc8985f6329dfcb4e50fef606",
           |    "actor":"ninject",
           |    "page_name":"Home",
           |    "actor_gravatar":"b46527233865dd59f195fe0c2115a6e0",
           |    "action":"created"
           |
           |}
         """.stripMargin)

      GollumEventPayload(json) shouldBe 'defined
   }
}
