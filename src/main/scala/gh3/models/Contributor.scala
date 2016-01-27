package gh3.models

import gh3._
import net.liftweb.json.JsonAST.JValue

case class Contributor(name: String, email: String, username: String)

object Contributor
{
   def apply(json: JValue): Option[Contributor] =
   {
      val n2s = node2String(json)(_)

      val name = n2s("name")
      val email = n2s("email")
      val username = n2s("username")

      if(Seq(name, email, username).forall(_.isDefined))
         Some(new Contributor(name.get, email.get, username.get))
      else None
   }
}