package gh2013.payloads

import net.liftweb.json.JsonAST.JValue


case class DeleteEventPayload(ref: String, ref_type: String)

object DeleteEventPayload
{
   def apply(json: JValue): Option[DeleteEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)

      val ref = n2s("ref")
      val ref_type = n2s("ref_type")

      val params = Seq(ref, ref_type)

      if(params.forall(_.isDefined))
         Some(DeleteEventPayload(ref.get, ref_type.get))
      else None
   }
}