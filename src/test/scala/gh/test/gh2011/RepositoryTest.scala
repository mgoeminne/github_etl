package gh.test.gh2011

import gh2011.models.Repository
import org.scalatest.{Matchers, FlatSpec}
import net.liftweb.json._



class RepositoryTest extends FlatSpec with Matchers
{
   "A valid Repository" must "be correclty parsed" in {
      val json = parse(
         """
           | {
           |
           |    "id":355634,
           |    "url":"https://api.github.dev/repos/projectblacklight/blacklight",
           |    "name":"projectblacklight/blacklight"
           |
           |}
         """.stripMargin)

      Repository(json).isDefined shouldBe true
   }
}
