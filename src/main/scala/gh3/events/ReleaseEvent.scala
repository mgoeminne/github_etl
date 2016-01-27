package gh3.events

import gh3._
import net.liftweb.json.JsonAST.JValue

case class ReleaseEvent(
                          action: String,
                          release: GH3Release,
                          repository: GH3Repository,
                          sender: GH3Sender
                       ) extends GH3Event

object ReleaseEvent
{
   def apply(json: JValue): Option[ReleaseEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val release = GH3Release(json \ "release")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, release, repository, sender).forall(_.isDefined))
         Some(new ReleaseEvent(action.get, release.get, repository.get, sender.get))
      else None
   }
}
