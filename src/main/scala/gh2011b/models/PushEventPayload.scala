package gh2011b.models

import net.liftweb.json.JsonAST.{JArray, JValue}

case class PushEventPayload(shas: Seq[Option[String]], ref: String, size: Option[Long], head: String, push_id: Long)

object PushEventPayload
{
   def apply(json: JValue): Option[PushEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2os = gh3.node2OptionString(json)(_)
      def n2l = gh3.node2Long(json)(_)
      def n2ol = gh3.node2OptionLong(json)(_)

      def shas = (json \ "shas") match {
         case JArray(x) => Some(x map (e => gh3.directNode2String(e)))
         case _ => Some(Seq())
      }

      def ref = n2s("ref")
      def size = n2ol("size")
      def head = n2s("head")
      def push_id = n2l("push_id")

      val params = Seq(shas, ref, size, head, push_id)


      if(params.forall(_.isDefined)) Some(PushEventPayload(shas.get, ref.get, size.get, head.get, push_id.get))
      else None
   }
}

