package gh.test.gh2013.event

import gh2013.events.{CommitCommentEventParser, CreateEventParser, FollowEventParser}
import net.liftweb.json._
import org.scalatest.{FlatSpec, Matchers}


class CommitCommentEventTest extends FlatSpec with Matchers
{
   "A valid CommitCommentEvent" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "actor":"xenji",
           |    "public":true,
           |    "created_at":"2013-01-01T00:52:02-08:00",
           |    "type":"CommitCommentEvent",
           |    "payload":{
           |        "comment_id":2370688,
           |        "commit":"29612017f6a84eb02714693738d5031209bfd87a"
           |    },
           |    "repository":{
           |        "watchers":0,
           |        "has_wiki":true,
           |        "owner":"xenji",
           |        "created_at":"2012-12-30T09:17:12-08:00",
           |        "homepage":"http://jekyllrb.com",
           |        "stargazers":0,
           |        "open_issues":0,
           |        "pushed_at":"2012-12-30T22:21:39-08:00",
           |        "url":"https://github.com/xenji/jekyll",
           |        "description":"Jekyll is a blog-aware, static site generator in Ruby",
           |        "forks":0,
           |        "has_issues":false,
           |        "fork":true,
           |        "size":136,
           |        "has_downloads":true,
           |        "name":"jekyll",
           |        "language":"Ruby",
           |        "id":7378503,
           |        "private":false
           |    },
           |    "actor_attributes":{
           |        "blog":"http://www.xenji.com",
           |        "login":"xenji",
           |        "location":"Duesseldorf, Germany",
           |        "gravatar_id":"6f676db35d9c4a3b701ca41f266d693c",
           |        "type":"User",
           |        "name":"Mario Mueller",
           |        "company":"trivago GmbH",
           |        "email":"mario@xenji.com"
           |    },
           |    "url":"https://github.com/xenji/jekyll/commit/29612017f6a84eb02714693738d5031209bfd87a#test/test_configuration.rb-P17"
           |
           |}
         """.stripMargin)

      gh2013.parser(CommitCommentEventParser)(json) shouldBe 'defined
   }
}
