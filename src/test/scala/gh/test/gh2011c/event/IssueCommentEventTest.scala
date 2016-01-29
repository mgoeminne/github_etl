package gh.test.gh2011c.event

import gh2011b.events.{IssuesEventParser}
import gh2011c.events.IssueCommentEventParser
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class IssueCommentEventTest extends FlatSpec with Matchers
{
   "A valid IssueCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           |{
           |
           |    "type":"IssueCommentEvent",
           |    "public":true,
           |    "actor":{
           |        "gravatar_id":"f8634aca904bc63cb047cb1bd93bdc74",
           |        "url":"https://api.github.com/users/evan",
           |        "avatar_url":"https://secure.gravatar.com/avatar/f8634aca904bc63cb047cb1bd93bdc74?d=%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
           |        "id":210,
           |        "login":"evan"
           |    },
           |    "created_at":"2011-10-07T23:59:31Z",
           |    "payload":{
           |        "comment":{
           |            "created_at":"2011-10-07T23:59:31Z",
           |            "body":"Ok, it sounds like rvmsudo is damaging your link environment somehow. I am going to release this build and close for now. Thanks both of you for all your help.",
           |            "updated_at":"2011-10-07T23:59:31Z",
           |            "url":"https://api.github.com/repos/fauna/memcached/issues/comments/2329706",
           |            "id":2329706,
           |            "user":{
           |                "avatar_url":"https://secure.gravatar.com/avatar/f8634aca904bc63cb047cb1bd93bdc74?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
           |                "url":"https://api.github.com/users/evan",
           |                "id":210,
           |                "login":"evan"
           |            }
           |        },
           |        "action":"created",
           |        "issue":{
           |            "number":52,
           |            "created_at":"2011-07-05T22:17:32Z",
           |            "pull_request":{
           |                "diff_url":null,
           |                "patch_url":null,
           |                "html_url":null
           |            },
           |            "body":"Version 1.2.7 fails to install on RHEL6.1. Version 1.2.6 installs fine. Output of build failure and gem_make.out at https://gist.github.com/868793135b0d8db77c70\r\n\r\nLibraries and devel headers are installed for sasl, libmemcache, and memcache:\r\n\r\n[vstsbx01:~] root# rpm -qa|egrep 'sasl|memcac'|sort\r\ncyrus-sasl-2.1.23-8.el6.x86_64\r\ncyrus-sasl-devel-2.1.23-8.el6.x86_64\r\ncyrus-sasl-gssapi-2.1.23-8.el6.x86_64\r\ncyrus-sasl-lib-2.1.23-8.el6.x86_64\r\ncyrus-sasl-plain-2.1.23-8.el6.x86_64\r\nlibmemcached-0.31-1.1.el6.x86_64\r\nlibmemcached-devel-0.31-1.1.el6.x86_64\r\nmemcached-1.4.4-3.el6.x86_64\r\nmemcached-devel-1.4.4-3.el6.x86_64",
           |            "comments":46,
           |            "title":"Install fails on RHEL6, v1.2.7",
           |            "updated_at":"2011-10-07T23:59:31Z",
           |            "url":"https://api.github.com/repos/fauna/memcached/issues/52",
           |            "id":1170572,
           |            "assignee":{
           |                "avatar_url":"https://secure.gravatar.com/avatar/e35b8aac0c907bd2167bb3a7b9d3ca61?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
           |                "url":"https://api.github.com/users/bitbckt",
           |                "id":335,
           |                "login":"bitbckt"
           |            },
           |            "milestone":null,
           |            "closed_at":null,
           |            "user":{
           |                "avatar_url":"https://secure.gravatar.com/avatar/b97a5e7cb0d66ca79a7d81de371e8791?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
           |                "url":"https://api.github.com/users/ryanschwartz",
           |                "id":4556,
           |                "login":"ryanschwartz"
           |            },
           |            "html_url":"https://github.com/fauna/memcached/issues/52",
           |            "labels":[
           |            ],
           |            "state":"open"
           |        },
           |        "legacy":{
           |            "issue_id":1170572,
           |            "comment_id":2329706
           |        }
           |    },
           |    "id":"1491327137",
           |    "org":{
           |        "gravatar_id":"42114e3b01d60357fc1ab7a059d23be6",
           |        "url":"https://api.github.com/orgs/fauna",
           |        "avatar_url":"https://secure.gravatar.com/avatar/42114e3b01d60357fc1ab7a059d23be6?d=%2Fimages%2Fgravatars%2Fgravatar-org-420.png",
           |        "id":7144,
           |        "login":"fauna"
           |    },
           |    "repo":{
           |        "url":"https://api.github.com/repos/fauna/memcached",
           |        "id":24449,
           |        "name":"fauna/memcached"
           |    }
           |
           |}
         """.stripMargin)

      gh2011c.parser(IssueCommentEventParser)(json) shouldBe 'defined
   }
}
