package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class GollumEventPayload(title: String, summary: Option[String], repo: String, sha: String, actor: Option[String],
                              page_name: String, actor_gravatar: Option[String], action: String)

object GollumEventPayload
{
   def apply(json: JValue): Option[GollumEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val title = n2s("title")
      val summary = n2os("summary")
      val repo = n2s("repo")
      val sha = n2s("sha")
      val actor = n2os("actor")
      val page_name = n2s("page_name")
      val actor_gravatar = n2os("actor_gravatar")
      val action = n2s("action")

      val params = Seq(title, summary, repo, sha, actor, page_name, actor_gravatar, action)

      if(params.forall(_.isDefined))
         Some(GollumEventPayload(title.get, summary.get, repo.get, sha.get, actor.get, page_name.get,
            actor_gravatar.get, action.get))
      else None
   }
}
