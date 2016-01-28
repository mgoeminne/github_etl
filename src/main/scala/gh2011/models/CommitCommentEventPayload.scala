package gh2011.models

import net.liftweb.json.JsonAST.JValue


case class CommitCommentEventPayload(repo: String, actor: String, comment_id: Long, actor_gravatar: String,
                                     commit: String)

object CommitCommentEventPayload
{
   def apply(json: JValue): Option[CommitCommentEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val repo =  n2s("repo")
      val actor = n2s("actor")
      val comment_id = n2l("comment_id")
      val actor_gravatar = n2s("actor_gravatar")
      val commit = n2s("commit")

      val params = Seq(repo, actor, comment_id, actor_gravatar, commit)

      if(params.forall(_.isDefined))
         Some(CommitCommentEventPayload(repo.get, actor.get, comment_id.get, actor_gravatar.get, commit.get))
      else None
   }
}
