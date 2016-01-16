package gh3

import net.liftweb.json.JsonAST.{JArray, JValue}
import org.joda.time.LocalDateTime


case class GH3Release(
                        url: String,
                        assets_url: String,
                        upload_url: String,
                        html_url: String,
                        id: Long,
                        tag_name: String,
                        target_commitish: String,
                        name: Option[String],
                        draft: Boolean,
                        author: GH3Sender,
                        prerelease: Boolean,
                        created_at: LocalDateTime,
                        published_at: LocalDateTime,
                        assets: Seq[String],
                        tarball_url: String,
                        zipball_url: String,
                        body: Option[String]
                     )

object GH3Release
{
   def apply(json: JValue): Option[GH3Release] =
   {
      val n2s = (tag: String) => node2String(json \ tag)

      val url = n2s("url")
      val assets_url = n2s("assets_url")
      val upload_url = n2s("upload_url")
      val html_url = n2s("html_url")
      val id = node2Long(json \ "id")
      val tag_name = n2s("tag_name")
      val target_commitish = n2s("target_commitish")
      val name = node2OptionString(json \ "name")
      val draft = node2Boolean(json \ "draft")
      val author = GH3Sender(json \ "author")
      val prerelease = node2Boolean(json \ "prerelease")
      val created_at = node2LocalDateTime(json \ "created_at")
      val published_at = node2LocalDateTime(json \ "published_at")
      val assets = (json \ "assets") match {
         case JArray(x) => Some(x.map(node2String(_).get))
         case _ => None
      }
      val tarball_url = n2s("tarball_url")
      val zipball_url = n2s("zipball_url")
      val body = node2OptionString(json \ "body")

      val params = Seq(url, assets_url, upload_url, html_url, id, tag_name, target_commitish, name, draft, author,
      prerelease, created_at, published_at, assets, tarball_url, zipball_url, body)

      if(params.forall(_.isDefined))
         Some(new GH3Release(url.get, assets_url.get, upload_url.get, html_url.get, id.get, tag_name.get,
         target_commitish.get, name.get, draft.get, author.get, prerelease.get, created_at.get, published_at.get,
         assets.get, tarball_url.get, zipball_url.get, body.get))
      else None
   }
}