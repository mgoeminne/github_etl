package gh2013.payloads

import net.liftweb.json.JsonAST.JValue


case class IssueCommentEventPayload(issue_id: Long, comment_id: Long)

object IssueCommentEventPayload
{
   def apply(json: JValue): Option[IssueCommentEventPayload] =
   {
      val n2l = gh3.node2Long(json)(_)

      val issue_id = n2l("issue_id")
      val comment_id = n2l("comment_id")

      if(Seq(issue_id, comment_id).forall(_.isDefined)) Some(IssueCommentEventPayload(issue_id.get, comment_id.get))
      else None
   }
}
