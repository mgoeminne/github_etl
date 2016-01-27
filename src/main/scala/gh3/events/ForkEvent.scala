package gh3.events

import gh3.models.{GH3Sender, GH3Repository, GH3Forkee}
import net.liftweb.json.JsonAST.JValue

case class ForkEvent( forkee: GH3Forkee,
                      repository: GH3Repository,
                      sender: GH3Sender) extends GH3Event

object ForkEvent
{
   def apply(json: JValue): Option[ForkEvent] =
   {
      val forkee = GH3Forkee(json \ "forkee")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(forkee, repository, sender).forall(_.isDefined))
         Some(new ForkEvent(forkee.get, repository.get, sender.get))
      else None
   }
}
