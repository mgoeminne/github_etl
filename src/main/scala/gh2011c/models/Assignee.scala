package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class Assignee(avatar_url: String, url: String, id: Long, login: String)

object Assignee
{
   def apply(json: JValue): Option[Assignee] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val avatar_url = n2s("avatar_url")
      val url = n2s("url")
      val id = n2l("id")
      val login = n2s("login")

      val params = Seq(avatar_url, url, id, login)

      if(params.forall(_.isDefined)) Some(Assignee(avatar_url.get, url.get, id.get, login.get))
      else None
   }
}