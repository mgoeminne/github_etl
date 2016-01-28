package gh.test.gh2011.payload

import gh2011.models.CreateEventPayload
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class CreateEventPayloadTest extends FlatSpec with Matchers
{
   "A valid Create Event Payload" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "name":"syed_project_app",
           |    "object":"repository",
           |    "object_name":null
           |
           |}
         """.stripMargin)

      CreateEventPayload(json).isDefined shouldBe true
   }
}
