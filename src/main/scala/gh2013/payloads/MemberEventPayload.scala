package gh2013.payloads

import gh2013.models.User
import net.liftweb.json.JsonAST.JValue

case class MemberEventPayload(action: String, member: User)

object MemberEventPayload
{
   def apply(json: JValue): Option[MemberEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)

      val action = n2s("action")
      val member = User(json \ "member")

      val params = Seq(action, member)

      if(params.forall(_.isDefined))
         Some(MemberEventPayload(action.get, member.get))
      else None
   }
}
