package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class IssueCommentEventPayload(comment: IssueComment, action: String, issue: Issue, legacy: Legacy)

object IssueCommentEventPayload
{
   def apply(json: JValue): Option[IssueCommentEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val comment = IssueComment(json \ "comment")
      val action = n2s("action")
      val issue = Issue(json \ "issue")
      val legacy = Legacy(json \ "legacy")

      val params = Seq(comment, action, issue, legacy)

      if(params.forall(_.isDefined)) Some(IssueCommentEventPayload(comment.get, action.get, issue.get, legacy.get))
      else None
   }
}
