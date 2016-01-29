package gh2011c.models

import net.liftweb.json.JsonAST.{JValue, JArray}
import org.joda.time.LocalDateTime

case class Issue(number: Long, created_at: LocalDateTime, pull_request: PullRequest, body: String, comments: Long,
                 title: String, updated_at: LocalDateTime, url: String, id: Long, assignee: Assignee,
                 milestone: Option[String], closed_at: Option[LocalDateTime], user: IssueUser, html_url: String,
                 labels: Seq[String], state: String)

object Issue
{
   def apply(json: JValue): Option[Issue] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)
      val n2oldt = gh3.node2OptionLocalDateTime(json)(_)

      val number = n2l("number")
      val created_at = n2ldt("created_at")
      val pull_request = PullRequest(json \ "pull_request")
      val body = n2s("body")
      val comments = n2l("comments")
      val title = n2s("title")
      val updated_at = n2ldt("updated_at")
      val url = n2s("url")
      val id = n2l("id")
      val assignee = Assignee(json \ "assignee")
      val milestone = n2os("milestone")
      val closed_at = n2oldt("closed_at")
      val user = IssueUser(json \ "user")
      val html_url = n2s("html_url")
      val labels = (json \ "labels") match {
         case JArray(x) => x.map(e => gh3.directNode2String(e).get)
         case _ => Seq()
      }
      val state = n2s("state")

      val params = Seq(number, created_at, pull_request, body, comments, title, updated_at, url, id, assignee,
         milestone, closed_at, user, html_url, state)

      if(params.forall(_.isDefined))
         Some(Issue( number.get, created_at.get, pull_request.get, body.get, comments.get, title.get, updated_at.get,
                     url.get, id.get, assignee.get, milestone.get, closed_at.get, user.get, html_url.get, labels, state.get)
      )
      else None
   }
}