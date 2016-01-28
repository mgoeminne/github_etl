package gh2011.models

import net.liftweb.json.JsonAST.JValue


case class CreateEventPayload(name: String, `object`: String, object_name: Option[String])

object CreateEventPayload
{
   def apply(json: JValue): Option[CreateEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val name = n2s("name")
      val `object` = n2s("object")
      val object_name = n2os("object_name")

      val params = Seq(name, `object`, object_name)

      if(params.forall(_.isDefined))
         Some(CreateEventPayload(name.get, `object`.get, object_name.get))
      else None
   }
}
