package gh3.events

import gh3._
import gh3.models.{GH3Team, GH3Sender, GH3Organization}
import net.liftweb.json.JsonAST.JValue

case class MembershipEvent(
                             action: String,
                             scope: String,
                             member: GH3Sender,
                             sender: GH3Sender,
                             team: GH3Team,
                             organization: GH3Organization
                          ) extends GH3Event

object MembershipEvent extends GH3EventParser
{
   def apply(json: JValue): Option[MembershipEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val scope  = n2s("scope")
      val member = GH3Sender(json \ "member")
      val sender = GH3Sender(json \ "sender")
      val team   = GH3Team(json \ "team")
      val organization = GH3Organization(json \ "organization")

      if(Seq(action, scope, member, sender, team, organization).forall(_.isDefined))
         Some(new MembershipEvent(action.get, scope.get, member.get, sender.get, team.get, organization.get))
      else None
   }
}