package gh2013.events

import net.liftweb.json.JsonAST.JValue

case class ActorAttributes(gravatar_id: String, login: String, `type`: String)

object ActorAttributes
{
   def apply(json: JValue): Option[ActorAttributes] =
   {
      val n2s = gh3.node2String(json)(_)

      val gravatar_id = n2s("gravatar_id")
      val login = n2s("login")
      val `type` = n2s("type")

      val params = Seq(gravatar_id, login, `type`)

      if(params.forall(_.isDefined)) Some(ActorAttributes(gravatar_id.get, login.get, `type`.get))
      else None
   }
}
