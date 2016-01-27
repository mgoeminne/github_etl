package gh3.events

import gh3._
import net.liftweb.json.JsonAST.JValue

case class WatchEvent(
                        action: String,
                        repository: GH3Repository,
                        sender: GH3Sender
                     ) extends GH3Event

object WatchEvent
{
   def apply(json: JValue): Option[WatchEvent] =
   {
      val action = node2String(json)("action")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, repository, sender).forall(_.isDefined))
         Some(new WatchEvent(action.get, repository.get, sender.get))
      else None
   }
}