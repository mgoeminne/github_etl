package gh2011.events

import gh2011.models._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class PushEvent(repo: Repository,
                     org: Option[Organization],
                     created_at: LocalDateTime,
                     payload: PushEventPayload,
                     actor: Actor
                    ) extends Event

object PushEvent extends EventParser
{
   override def apply(json: JValue): Option[PushEvent] =
   {
      val `type` = gh3.node2String(json)("type")
      if(`type`.isEmpty || `type`.get != "PushEvent") return None

      val repo = Repository(json \ "repo")
      val org = Organization(json \ "org")
      val created_at = gh3.node2LocalDateTime(json)("created_at")
      val payload = PushEventPayload(json \ "payload")
      val actor = Actor(json \ "actor")


      val params = Seq(repo, created_at, payload, actor)

      if(params.forall(_.isDefined))
         Some(PushEvent(repo.get, org, created_at.get, payload.get, actor.get))
      else None
   }
}