package gh3.events

import gh3._
import net.liftweb.json.JsonAST.JValue

case class DeleteEvent(
                         ref: String,
                         ref_type: String,
                         pusher_type: String,
                         repository: GH3Repository,
                         sender: GH3Sender
                      ) extends GH3Event

object DeleteEvent
{
   def apply(json: JValue): Option[DeleteEvent] =
   {
      val n2s = node2String(json)(_)

      val ref = n2s("ref")
      val ref_type = n2s("ref_type")
      val pusher_type = n2s("pusher_type")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, ref_type, pusher_type, repository, sender)

      if(params.forall(_.isDefined))
         Some(new DeleteEvent(ref.get, ref_type.get, pusher_type.get, repository.get, sender.get))
      else None
   }
}