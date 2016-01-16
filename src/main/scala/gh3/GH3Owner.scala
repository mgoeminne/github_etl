package gh3

import net.liftweb.json.JsonAST.JValue

case class GH3Owner(name: String, email: String)

object GH3Owner
{
   def apply(json: JValue): Option[GH3Owner] =
   {
      val n2s = node2String(json)(_)

      val name = n2s("name")
      val email = n2s("email")

      if(Seq(name, email).forall(_.isDefined))
         Some(new GH3Owner(name.get, email.get))
      else None
   }
}