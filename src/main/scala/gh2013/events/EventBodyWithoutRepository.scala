package gh2013.events

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime


case class EventBodyWithoutRepository(actor: String, public: Boolean, url: String, actor_attributes: ActorAttributes,
                                      created_at: LocalDateTime)

object EventBodyWithoutRepository
{
   def apply(json: JValue): Option[EventBodyWithoutRepository] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2b = gh3.node2Boolean(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)

      val actor = n2s("actor")
      val public = n2b("public")
      val url = n2s("url")
      val actor_attributes = ActorAttributes(json \ "actor_attributes")
      val created_at = n2ldt("created_at")

      val params = Seq(actor, public, url, actor_attributes, created_at)

      if(params.forall(_.isDefined))
         Some(EventBodyWithoutRepository(actor.get, public.get, url.get, actor_attributes.get, created_at.get))
      else None
   }
}