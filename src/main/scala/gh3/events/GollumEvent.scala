package gh3.events

import gh3.models.{GH3Sender, GH3Repository, GH3Page}
import net.liftweb.json.JsonAST.{JArray, JValue}

case class GollumEvent( pages: Seq[GH3Page],
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object GollumEvent extends GH3EventParser
{
   def apply(json: JValue): Option[GollumEvent] =
   {
      val pages = (json \ "pages") match {
         case JArray(a) => Some(a.map(x => GH3Page(x)))
         case _ => None
      }

      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(pages, repository, sender).forall(_.isDefined))
         Some(new GollumEvent(pages.get.map(_.get), repository.get, sender.get))
      else
         None
   }
}