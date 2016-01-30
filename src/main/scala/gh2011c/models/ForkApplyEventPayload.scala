package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class ForkApplyEventPayload(head: String, after: String, before: String)

object ForkApplyEventPayload
{
   def apply(json: JValue): Option[ForkApplyEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2l = gh3.node2Long(json)(_)

      val head = n2s("head")
      val after = n2s("after")
      val before = n2s("before")

      val params = Seq(head, after, before)

      if(params.forall(_.isDefined)) Some(ForkApplyEventPayload(head.get, after.get, before.get))
      else None
   }
}

