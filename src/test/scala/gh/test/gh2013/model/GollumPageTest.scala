import gh2011.models.Repository
import gh2013.models.{GollumPage, PullRequest}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}

class GollumPageTest extends FlatSpec with Matchers
{
   "A valid GollumPage" must "be correctly parsed" in {
      val json = parse(
         """
           |     {
           |        "title":"Home",
           |        "action":"edited",
           |        "html_url":"https://github.com/hudec/sql-processor/wiki/Home",
           |        "page_name":"Home",
           |        "sha":"b5cfd5f62ef7f76abc82495f5e9d3d146b6d7a4d",
           |        "summary":null
           |    }
         """.stripMargin)

      GollumPage(json) shouldBe 'defined
   }
}
