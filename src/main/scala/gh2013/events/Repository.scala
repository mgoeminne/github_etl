package gh2013.events

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class Repository(watchers: Long, owner: String, created_at: LocalDateTime, stargazers: Long, open_issues: Long,
                      has_issues: Boolean, has_wiki: Boolean, pushed_at: LocalDateTime, url: String,
                      description: String, forks: Long, size: Long, name: String, language: String, id: Long,
                      `private`: Boolean, has_downloads: Boolean)

object Repository
{
   def apply(json: JValue): Option[Repository] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)
      val n2b = gh3.node2Boolean(json)(_)

      val watchers = n2l("watchers")
      val owner = n2s("owner")
      val created_at = n2ldt("created_at")
      val stargazers = n2l("stargazers")
      val open_issues = n2l("open_issues")
      val has_issues = n2b("has_issues")
      val has_wiki = n2b("has_wiki")
      val pushed_at = n2ldt("pushed_at")
      val url = n2s("url")
      val description = n2s("description")
      val forks = n2l("forks")
      val size = n2l("size")
      val name = n2s("name")
      val language = n2s("language")
      val id = n2l("id")
      val `private` = n2b("private")
      val has_downloads = n2b("has_downloads")

      val params = Seq(watchers, owner, created_at, stargazers, open_issues, has_issues, has_wiki, pushed_at, url,
         description, forks, size, name, language, id, `private`, has_downloads)

      if(params.forall(_.isDefined))
         Some(new Repository(watchers.get, owner.get, created_at.get, stargazers.get, open_issues.get, has_issues.get,
            has_wiki.get, pushed_at.get, url.get, description.get, forks.get, size.get, name.get, language.get, id.get,
            `private`.get, has_downloads.get))
      else None
   }
}