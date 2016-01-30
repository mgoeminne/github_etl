package gh2013.models

import net.liftweb.json.JsonAST.JValue

case class User(events_url: String, repos_url: String, url: String, organizations_url: String, id: Long,
                avatar_url: String, `type`: String, received_events_url: String,
                subscriptions_url: String, starred_url: String, login: String, followers_url: String,
                following_url: String, gists_url: String)

object User
{
   def apply(json: JValue): Option[User] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val events_url = n2s("events_url")
      val repos_url = n2s("repos_url")
      val url = n2s("url")
      val organizations_url = n2s("organizations_url")
      val id = n2l("id")
      val avatar_url = n2s("avatar_url")
      val `type` = n2s("type")
      val received_events_url = n2s("received_events_url")
      val subscriptions_url = n2s("subscriptions_url")
      val starred_url = n2s("starred_url")
      val login = n2s("login")
      val followers_url = n2s("followers_url")
      val following_url = n2s("following_url")
      val gists_url = n2s("gists_url")

      val params = Seq(events_url, repos_url, url, organizations_url, id, avatar_url, `type`,
         received_events_url, subscriptions_url, starred_url, login, followers_url, following_url, gists_url)

      if(params.forall(_.isDefined))
         Some(new User(events_url.get, repos_url.get, url.get, organizations_url.get, id.get, avatar_url.get,
            `type`.get, received_events_url.get, subscriptions_url.get, starred_url.get, login.get,
            followers_url.get, following_url.get, gists_url.get))
      else None
   }
}
