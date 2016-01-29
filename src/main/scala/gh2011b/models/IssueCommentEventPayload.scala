package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class IssueCommentEventPayload(comment_id: Long, issue_id: Long)

object IssueCommentEventPayload
{
   def apply(json: JValue): Option[IssueCommentEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val comment_id = n2l("comment_id")
      val issue_id = n2l("issue_id")

      val params = Seq(comment_id, issue_id)

      if(params.forall(_.isDefined)) Some(IssueCommentEventPayload(comment_id.get, issue_id.get))
      else None
   }
}
