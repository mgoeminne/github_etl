package gh2013.payloads

import gh2013.models.PublicEventSHA
import net.liftweb.json.JsonAST.{JArray, JValue}

case class PublicEventPayload(head: String, size: Long, shas: Seq[Option[PublicEventSHA]], ref: String)

object PublicEventPayload
{
   def apply(json: JValue): Option[PublicEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val d2s = gh3.directNode2String(_)
      val d2b = gh3.directNode2Boolean(_)

      val head = n2s("head")
      val size = n2l("size")
      val ref = n2s("ref")

      val shas: Seq[Option[PublicEventSHA]] = (json \ "shas") match {
         case JArray(x) => x.map(e => e match {
               case JArray(y) => if(y.size != 5) None
                                 else Some(PublicEventSHA(d2s(y(0)).get, d2s(y(1)).get, d2s(y(2)).get, d2s(y(3)).get,
                  d2b(y(4)).get))
               case _ => None
         })

         case _ => Seq()
      }

      val params = Seq(head, size, ref)

      if(params.forall(_.isDefined)) Some(new PublicEventPayload(head.get, size.get, shas, ref.get))
      else None
   }
}
