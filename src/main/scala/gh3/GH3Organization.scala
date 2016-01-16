package gh3

import net.liftweb.json.JsonAST.JValue

case class GH3Organization(
                           login: String,
                           id: Long,
                           url: String,
                           repos_url: String,
                           events_url: String,
                           members_url: String,
                           public_members_url: String,
                           avatar_url: String
                          )

object GH3Organization
{
   def apply(json: JValue): Option[GH3Organization] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)

      val login = n2s("login")
      val id = n2l("id")
      val url = n2s("url")
      val repos_url = n2s("repos_url")
      val events_url = n2s("events_url")
      val members_url = n2s("members_url")
      val public_members_url = n2s("public_members_url")
      val avatar_url = n2s("avatar_url")

      val params = Seq(login, id, url, repos_url, events_url, members_url, public_members_url, avatar_url)

      if(params.forall(_.isDefined))
         Some(new GH3Organization(login.get, id.get, url.get, repos_url.get, events_url.get, members_url.get,
            public_members_url.get, avatar_url.get))
      else None
   }
}
