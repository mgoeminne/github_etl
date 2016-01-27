package gh3.events

import gh3.{GH3Sender, GH3Repository, GH3Page}
import net.liftweb.json.JsonAST.{JArray, JValue}

case class GollumEvent( pages: Seq[GH3Page],
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object GollumEvent
{
   def apply(json: JValue): Option[GollumEvent] =
   {
      val pages = (json \ "pages") match {
         case JArray(a) => a.map(x => GH3Page(x))
      }

      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(repository, sender).forall(_.isDefined))
         Some(new GollumEvent(pages.map(_.get), repository.get, sender.get))
      else
         None
   }
}