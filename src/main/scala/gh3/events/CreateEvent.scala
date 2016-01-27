package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository}
import net.liftweb.json.JsonAST.JValue

case class CreateEvent (
                          ref: String,
                          ref_type: String,
                          master_branch: String,
                          description: String,
                          pusher_type: String,
                          repository: GH3Repository,
                          sender: GH3Sender

                       ) extends GH3Event

object CreateEvent extends GH3EventParser
{
   def apply(json: JValue): Option[CreateEvent] =
   {
      val n2s = node2String(json)(_)

      val ref = n2s("ref")
      val ref_type = n2s("ref_type")
      val master_branch = n2s("master_branch")
      val description = n2s("description")
      val pusher_type = n2s("pusher_type")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, ref_type, master_branch, description, pusher_type, repository, sender)

      if(params.forall(_.isDefined))
         Some(new CreateEvent(ref.get, ref_type.get, master_branch.get, description.get, pusher_type.get,
            repository.get, sender.get))
      else None
   }
}

