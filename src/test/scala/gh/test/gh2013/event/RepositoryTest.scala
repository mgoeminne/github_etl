package gh.test.gh2013.payload

import gh2011.models.Repository
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class RepositoryTest extends FlatSpec with Matchers
{
   "A valid EventBody" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "watchers":0,
           |    "owner":"moinmoin",
           |    "created_at":"2012-12-12T13:33:49-08:00",
           |    "stargazers":0,
           |    "open_issues":1,
           |    "has_issues":true,
           |    "has_wiki":true,
           |    "pushed_at":"2012-12-31T11:44:52-08:00",
           |    "url":"https://github.com/moinmoin/wso2registry-extensions",
           |    "description":"extensions supporting API management with wso2 governance registry",
           |    "forks":0,
           |    "fork":false,
           |    "size":212,
           |    "name":"wso2registry-extensions",
           |    "language":"Java",
           |    "id":7138004,
           |    "private":false,
           |    "has_downloads":true
           |
           |}
         """.stripMargin)

      Repository(json) shouldBe 'defined
   }
}
