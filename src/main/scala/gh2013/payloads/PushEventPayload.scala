package gh2013.payloads

import net.liftweb.json.JsonAST.{JArray, JValue}

case class PushEventPayload(size: Long, shas: Seq[SHA], ref: String, head: String)

object PushEventPayload
{
   def apply(json: JValue): Option[PushEventPayload] =
   {
      val n2l = gh3.node2Long(json)(_)
      val n2s = gh3.node2String(json)(_)

      val size = n2l("size")
      val shas = (json \ "shas") match {
         case JArray(x) => x.map(e => SHA(e))
         case _ => Seq()
      }

      val ref = n2s("ref")
      val head = n2s("head")

      val params = Seq(size, ref, head)

      if(params.forall(_.isDefined)) Some(new PushEventPayload(size.get, shas.flatten, ref.get, head.get))
      else None
   }
}
