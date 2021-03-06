package gh3.events

import gh3.models.{GH3Sender, GH3Repository}
import net.liftweb.json.JsonAST.JValue

case class PublicEvent(
                         repository: GH3Repository,
                         sender: GH3Sender
                      ) extends GH3Event

object PublicEvent extends GH3EventParser
{
   def apply(json: JValue): Option[PublicEvent] =
   {
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(repository, sender).forall(_.isDefined))
         Some(new PublicEvent(repository.get, sender.get))
      else None
   }
}