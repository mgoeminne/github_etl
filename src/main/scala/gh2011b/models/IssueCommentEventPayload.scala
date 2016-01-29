package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class IssueCommentEventPayload(repo: String, actor: String, issue_id: Long, comment_id: Long,
                                    actor_gravatar: String)

object IssueCommentEventPayload
{
   def apply(json: JValue): Option[IssueCommentEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val repo = n2s("repo")
      val actor = n2s("actor")
      val issue_id = n2l("issue_id")
      val comment_id = n2l("comment_id")
      val actor_gravatar = n2s("actor_gravatar")

      val params = Seq(repo, actor, issue_id, comment_id, actor_gravatar)

      if(params.forall(_.isDefined))
         Some(IssueCommentEventPayload(repo.get, actor.get, issue_id.get, comment_id.get, actor_gravatar.get))
      else None
   }
}
