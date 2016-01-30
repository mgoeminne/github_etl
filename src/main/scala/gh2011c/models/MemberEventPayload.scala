package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class MemberEventPayload(member: Member, action: String)

object MemberEventPayload
{
   def apply(json: JValue): Option[MemberEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val member = Member(json \ "member")
      val action = n2s("action")

      if(Seq(member, action).forall(_.isDefined)) Some(MemberEventPayload(member.get, action.get))
      else None
   }
}

