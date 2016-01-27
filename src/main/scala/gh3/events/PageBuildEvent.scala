package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3Build}
import net.liftweb.json.JsonAST.JValue

case class PageBuildEvent(
                            id: Long,
                            build: GH3Build,
                            repository: GH3Repository,
                            sender: GH3Sender
                         ) extends GH3Event

object PageBuildEvent
{
   def apply(json: JValue): Option[PageBuildEvent] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)

      val id = n2l("id")
      val build = GH3Build(json \ "build")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(id, build, repository, sender).forall(_.isDefined))
         Some(new PageBuildEvent(id.get, build.get, repository.get, sender.get))
      else None
   }
}