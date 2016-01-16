package gh3

import net.liftweb.json.JsonAST.{JValue}


case class GH3Sender(   login: String,
                        id: Long,
                        avatar_url: String,
                        gravatar_id: String,
                        url: String,
                        html_url: String,
                        followers_url: String,
                        following_url: String,
                        gists_url: String,
                        starred_url: String,
                        subscriptions_url: String,
                        organizations_url: String,
                        repos_url: String,
                        events_url: String,
                        received_events_url: String,
                        `type`: String,
                        site_admin: Boolean
                    )

object GH3Sender
{
   def apply(json: JValue): Option[GH3Sender] =
   {
      val n2s = node2String(json)(_)
      
      val login = n2s("login")
      val id = node2Long(json)("id").map(_.toInt)
      val avatar_url = n2s("avatar_url")
      val gravatar_id = n2s("gravatar_id")
      val url = n2s("url")
      val html_url = n2s("html_url")
      val followers_url = n2s("followers_url")
      val following_url = n2s("following_url")
      val gists_url = n2s("gists_url")
      val starred_url = n2s("starred_url")
      val subscriptions_url = n2s("subscriptions_url")
      val organizations_url = n2s("organizations_url")
      val repos_url = n2s("repos_url")
      val events_url = n2s("events_url")
      val received_events_url = n2s("received_events_url")
      val `type` = n2s("type")
      val site_admin = node2Boolean(json)("site_admin")
      
      val params = Seq(
         login,
         id,
         avatar_url,
         gravatar_id,
         url,
         html_url,
         followers_url,
         following_url,
         gists_url,
         starred_url,
         subscriptions_url,
         organizations_url,
         repos_url,
         events_url,
         received_events_url,
         `type`,
         site_admin
      )

      if(params.forall(_.isDefined)){
         Some(new GH3Sender(login.get, id.get, avatar_url.get, gravatar_id.get, url.get, html_url.get, followers_url.get,
            following_url.get, gists_url.get, starred_url.get, subscriptions_url.get, organizations_url.get,
            repos_url.get, events_url.get, received_events_url.get, `type`.get, site_admin.get))
      }
      else None
   }
}

