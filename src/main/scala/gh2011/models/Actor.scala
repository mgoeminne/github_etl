package gh2011.models

import gh2011.events.{Event, EventParser}
import net.liftweb.json.JsonAST.JValue

case class Actor(gravatar_id: String, id: Long, url: String, avatar_url: String, login: String)

object Actor
{
   def apply(json: JValue): Option[Actor] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val gravatar_id = n2s("gravatar_id")
      val id = n2l("id")
      val url = n2s("url")
      val avatar_url = n2s("avatar_url")
      val login = n2s("login")

      val params = Seq(gravatar_id, id, url, avatar_url, login)

      if(params.forall(_.isDefined))
         Some(Actor(gravatar_id.get, id.get, url.get, avatar_url.get, login.get))
      else None
   }
}