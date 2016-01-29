package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class GistEventPayload(name: String, desc: Option[String], actor: String, url: String, actor_gravatar: String,
                            snippet: String, action: String)

object GistEventPayload
{
   def apply(json: JValue): Option[GistEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val name = n2s("name")
      val desc = n2os("desc")
      val actor = n2s("actor")
      val url = n2s("url")
      val actor_gravatar = n2s("actor_gravatar")
      val snippet = n2s("snippet")
      val action = n2s("action")

      val params = Seq(name, desc, actor, url, actor_gravatar, snippet, action)

      if(params.forall(_.isDefined))
         Some(GistEventPayload(name.get, desc.get, actor.get, url.get, actor_gravatar.get, snippet.get, action.get))
      else None
   }
}
