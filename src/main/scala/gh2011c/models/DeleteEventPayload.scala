package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class DeleteEventPayload(ref_type: String, ref: String)

object DeleteEventPayload
{
   def apply(json: JValue): Option[DeleteEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)

      val ref_type = n2s("ref_type")
      val ref = n2s("ref")

      if(Seq(ref_type, ref).forall(_.isDefined)) Some(DeleteEventPayload(ref_type.get, ref.get))
      else None
   }
}

