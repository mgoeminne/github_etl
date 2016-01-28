package gh.test.gh2011.payload


import gh2011.models.{GistEventPayload, IssuesEventPayload}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GistEventPayloadTest extends FlatSpec with Matchers
{
   "A valid GistEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "name":"gist: 823336",
           |    "desc":"",
           |    "actor":"avalanche123",
           |    "url":"https://gist.github.com/823336",
           |    "actor_gravatar":"f000c9b4dd0656f60de1dc9e75f7386c",
           |    "snippet":"<?php\n\n$width = 400;",
           |    "action":"update"
           |
           |}
         """.stripMargin)

      GistEventPayload(json) shouldBe 'defined
   }
}
