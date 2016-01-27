package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository}
import net.liftweb.json.JsonAST.JValue

case class MemberEvent(
                         action: String,
                         member: GH3Sender,
                         repository: GH3Repository,
                         sender: GH3Sender
                      ) extends GH3Event

object MemberEvent extends GH3EventParser
{
   def apply(json: JValue): Option[MemberEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val member = GH3Sender(json \ "member")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, member, repository, sender).forall(_.isDefined))
         Some(new MemberEvent(action.get, member.get, repository.get, sender.get))
      else None
   }
}