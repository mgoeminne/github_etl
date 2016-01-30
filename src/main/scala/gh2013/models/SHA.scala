package gh2013.models

import net.liftweb.json.JsonAST.{JArray, JValue}

case class SHA(id: String, email: String, comment: String, author: String, unknown: Boolean)

object SHA
{
   def apply(json: JValue): Option[SHA] =
   {
      val n2s = gh3.directNode2String(_)
      val n2b = gh3.directNode2Boolean(_)

      json match {
         case JArray(x) => {
            if(x.size != 5) None
            else {
               val id = n2s(x(0))
               val email = n2s(x(1))
               val comment = n2s(x(2))
               val author = n2s(x(3))
               val unknown = n2b(x(4))

               val params = Seq(id, email, comment, author, unknown)

               if(params.forall(_.isDefined)) Some(SHA(id.get, email.get, comment.get, author.get, unknown.get))
               else None
            }
         }
         case _ => None
      }
   }
}