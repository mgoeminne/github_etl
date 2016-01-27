package gh2011.models

import gh2011.events.{Event, EventParser}
import net.liftweb.json.JsonAST.JValue

case class Repository(id: Long, url: String, name: String)

object Repository
{
   def apply(json: JValue): Option[Repository] =
   {
      val n2l = gh3.node2Long(json)(_)
      val n2s = gh3.node2String(json)(_)

      val id = n2l("id")
      val url = n2s("url")
      val name = n2s("name")

      if(Seq(id, url, name).forall(_.isDefined))
         Some(Repository(id.get, url.get, name.get))
      else None
   }
}
