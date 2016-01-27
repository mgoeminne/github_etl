package gh2011.events

import gh2011.models._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class PushEvent(repo: Repository,
                     org: Organization,
                     created_at: LocalDateTime,
                     payload: Payload,
                     actor: Actor
                    ) extends Event

object PushEvent extends EventParser
{
   override def apply(json: JValue): Option[PushEvent] =
   {
      val repo = Repository(json \ "repo")
      val org = Organization(json \ "org")
      val created_at = gh3.node2LocalDateTime(json)("created_at")
      val payload = Payload(json \ "payload")
      val actor = Actor(json \ "actor")

      val params = Seq(repo, org, created_at, payload, actor)

      println(params.map(_.isDefined))

      if(params.forall(_.isDefined))
         Some(PushEvent(repo.get, org.get, created_at.get, payload.get, actor.get))
      else None
   }
}