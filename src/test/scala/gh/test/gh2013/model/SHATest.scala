package gh.test.gh2013.model

import gh2013.payloads.{SHA, FollowEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class SHATest extends FlatSpec with Matchers
{
   "A valid SHA" must "be correctly parsed" in {
      val json = parse(
         """
           | [
           |
           |    "d55c296838fefaee5e7b60f2da75d47581d8c84c",
           |    "hamidreza.s@gmail.com",
           |    "Version 0.1.14.10.6 - Modifying date for Order Controller, but still it needs some modification",
           |    "Hamidrezas",
           |    true
           |
           |]
         """.stripMargin)

      SHA(json) shouldBe 'defined
   }
}
