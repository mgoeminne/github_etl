package gh2011b.models

import net.liftweb.json.JsonAST.JValue


case class LimitedCommitCommentEventPayload(comment_id: Long, commit: String)

object LimitedCommitCommentEventPayload
{
   def apply(json: JValue): Option[LimitedCommitCommentEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val comment_id = n2l("comment_id")
      val commit = n2s("commit")

      val params = Seq(comment_id, commit)

      if(params.forall(_.isDefined))
         Some(LimitedCommitCommentEventPayload(comment_id.get, commit.get))
      else None
   }
}
