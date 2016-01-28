package gh2011.events


import gh2011.models.{WatchEventPayload, Actor, Organization, Repository}
import gh3._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class WatchEvent(  id: String, repo: Repository, org: Organization, created_at: LocalDateTime,
                        payload: WatchEventPayload, actor: Actor) extends Event

object WatchEvent extends EventParser
{
   def apply(json: JValue): Option[WatchEvent] =
   {
      val `type` = node2String(json)("type")

      if(`type`.isEmpty || `type`.get != "WatchEvent") return None

      val id = gh3.node2String(json)("id")
      val repo = Repository(json \ "repo")
      val org = Organization(json \ "org")
      val created_at = gh3.node2LocalDateTime(json)("created_at")
      val payload = WatchEventPayload(json \ "payload")
      val actor = Actor(json \ "actor")

      val params = Seq(id, repo, org, created_at, payload, actor)

      if(params.forall(_.isDefined))
         Some(WatchEvent(id.get, repo.get, org.get, created_at.get, payload.get, actor.get))
      else None
   }
}