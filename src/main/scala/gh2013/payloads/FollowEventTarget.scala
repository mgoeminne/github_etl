package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class FollowEventTarget(id: Long, login: String, gravatar_id: String, repos: Long, followers: Long)

object FollowEventTarget
{
   def apply(json: JValue): Option[FollowEventTarget] =
   {
      val n2l = gh3.node2Long(json)(_)
      val n2s = gh3.node2String(json)(_)

      val id = n2l("id")
      val login = n2s("login")
      val gravatar_id = n2s("gravatar_id")
      val repos = n2l("repos")
      val followers = n2l("followers")

      val params = Seq(id, login, gravatar_id, repos, followers)

      if(params.forall(_.isDefined)) Some(FollowEventTarget(id.get, login.get, gravatar_id.get, repos.get, followers.get))
      else None
   }
}