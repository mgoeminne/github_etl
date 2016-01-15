package gh3

import net.liftweb.json.JsonAST.{JInt, JBool, JString, JValue}


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
      val login = node2String(json \ "login")
      val id = node2Long(json \ "id").map(_.toInt)
      val avatar_url = node2String(json \ "avatar_url")
      val gravatar_id = node2String(json \ "gravatar_id")
      val url = node2String(json \ "url")
      val html_url = node2String(json \ "html_url")
      val followers_url = node2String(json \ "followers_url")
      val following_url = node2String(json \ "following_url")
      val gists_url = node2String(json \ "gists_url")
      val starred_url = node2String(json \ "starred_url")
      val subscriptions_url = node2String(json \ "subscriptions_url")
      val organizations_url = node2String(json \ "organizations_url")
      val repos_url = node2String(json \ "repos_url")
      val events_url = node2String(json \ "events_url")
      val received_events_url = node2String(json \ "received_events_url")
      val `type` = node2String(json \ "type")
      val site_admin = node2Boolean(json \ "site_admin")
      
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

   private def node2String(node: JValue): Option[String] =
   {
      node match {
         case JString(x) => Some(x)
         case _ => None
      }
   }

   private def node2Boolean(node: JValue): Option[Boolean] =
   {
      node match {
         case JBool(x) => Some(x)
         case _ => None
      }
   }

   private def node2Long(node: JValue): Option[Long] =
   {
      node match {
         case JInt(x) => Some(x.toLong)
         case _ => None
      }
   }
}

