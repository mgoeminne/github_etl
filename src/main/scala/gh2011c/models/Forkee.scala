package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class Forkee(name: String, public: Boolean, id: Long)

object Forkee
{
   def apply(json: JValue): Option[Forkee] =
   {
      val name = gh3.node2String(json)("name")
      val public = gh3.node2Boolean(json)("public")
      val id = gh3.node2Long(json)("id")

      val params = Seq(name, public, id)

      if(params.forall(_.isDefined)) Some(Forkee(name.get, public.get, id.get))
      else None
   }
}