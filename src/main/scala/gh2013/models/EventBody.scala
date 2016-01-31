package gh2013.models

import gh2013.events.ActorAttributes
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime


case class EventBody(actor: String, public: Boolean, url: String, repository: Repository,
                     actor_attributes: ActorAttributes, created_at: LocalDateTime)

object EventBody
{
   def apply(json: JValue): Option[EventBody] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2b = gh3.node2Boolean(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)

      val actor = n2s("actor")
      val public = n2b("public")
      val url = n2s("url")
      val repository = Repository(json \ "repository")
      val actor_attributes = ActorAttributes(json \ "actor_attributes")
      val created_at = n2ldt("created_at")

      val params = Seq(actor, public, url, repository, actor_attributes, created_at)

      if(params.forall(_.isDefined))
         Some(EventBody(actor.get, public.get, url.get, repository.get, actor_attributes.get, created_at.get))
      else None
   }
}