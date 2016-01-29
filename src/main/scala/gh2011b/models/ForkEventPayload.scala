package gh2011b.models

import net.liftweb.json.JsonAST.JValue

case class ForkEventPayload(forkee: Forkee)

object ForkEventPayload
{
   def apply(json: JValue): Option[ForkEventPayload] =
   {
      val forkee = Forkee(json \ "forkee")

      println(forkee.isDefined)

      if(forkee.isDefined) Some(ForkEventPayload(forkee.get))
      else None
   }
}

