package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class FollowEventTarget(gravatar_id: String, repos: Long, followers: Long, login: String)

object FollowEventTarget
{
   def apply(json: JValue): Option[FollowEventTarget] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val gravatar_id = n2s("gravatar_id")
      val repos = n2l("repos")
      val followers = n2l("followers")
      val login = n2s("login")

      val params = Seq(gravatar_id, repos, followers, login)

      if(params.forall(_.isDefined)) Some(FollowEventTarget(gravatar_id.get, repos.get, followers.get, login.get))
      else None
   }
}