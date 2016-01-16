package gh3

import net.liftweb.json.JsonAST.JValue


case class GH3Team(
                     name: String,
                     id: Long,
                     slug: String,
                     permission: String,
                     url: String,
                     members_url: String,
                     repositories_url: String
                  )

object GH3Team
{
   def apply(json: JValue): Option[GH3Team] =
   {
      val n2s = node2String(json)(_)
      
      val name = n2s("name")
      val id   = node2Long(json)("id")
      val slug = n2s("slug")
      val permission = n2s("permission")
      val url = n2s("url")
      val members_url = n2s("members_url")
      val repositories_url = n2s("repositories_url")

      val params = Seq(name, id, slug, permission, url, members_url, repositories_url)

      if(params.forall(_.isDefined))
         Some(new GH3Team(name.get, id.get, slug.get, permission.get, url.get, members_url.get, repositories_url.get))
      else None
   }
}