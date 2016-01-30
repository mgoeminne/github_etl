package gh2011c.models

import net.liftweb.json.JsonAST.JValue


case class Member(gravatar_id: String, id: Long, login: String)

object Member
{
   def apply(json: JValue): Option[Member] =
   {
      def gravatar_id = gh3.node2String(json)("gravatar_id")
      def id = gh3.node2Long(json)("id")
      def login = gh3.node2String(json)("login")

      if(Seq(gravatar_id, id, login).forall(_.isDefined)) Some(Member(gravatar_id.get, id.get, login.get))
      else None
   }
}