package gh2013.events

import gh2013.models.EventBody
import gh2013.payloads._
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class PushEvent(event: EventBody, payload: PushEventPayload) extends GH2013Event

case class WatchEvent(event: EventBody, payload: WatchEventPayload) extends GH2013Event

case class CreateEvent(event: EventBody, payload: CreateEventPayload) extends GH2013Event

case class IssuesEvent(event: EventBody, payload: IssuesEventPayload) extends GH2013Event

case class ForkEvent(event: EventBody, payload: ForkEventPayload) extends GH2013Event

case class PublicEvent(actor: String, public: Boolean, url: String, actor_attributes: ActorAttributes,
                       created_at: LocalDateTime) extends GH2013Event

object PublicEvent
{
   def apply(json: JValue): Option[PublicEvent] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2b = gh3.node2Boolean(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)

      val `type` = n2s("type")

      if(`type`.isEmpty || `type`.get != "PublicEvent") return None

      val actor = n2s("actor")
      val public = n2b("public")
      val url = n2s("url")
      val actor_attributes = ActorAttributes(json \ "actor_attributes")
      val created_at = n2ldt("created_at")

      val params = Seq(actor, public, url, actor_attributes, created_at)

      if(params.forall(_.isDefined))
         return Some(PublicEvent(actor.get, public.get, url.get, actor_attributes.get, created_at.get))
      else return None
   }
}

case class PullRequestEvent(event: EventBody, payload: PullRequestEventPayload) extends GH2013Event

case class DeleteEvent(event: EventBody, payload: DeleteEventPayload) extends GH2013Event

case class GistEvent(actor: String, public: Boolean, url: String, actor_attributes: ActorAttributes,
                     created_at: LocalDateTime, payload: GistEventPayload) extends GH2013Event

object GistEvent
{
   def apply(json: JValue): Option[GistEvent] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2b = gh3.node2Boolean(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)

      val `type` = n2s("type")

      if(`type`.isEmpty || `type`.get != "GistEvent") return None

      val actor = n2s("actor")
      val public = n2b("public")
      val url = n2s("url")
      val actor_attributes = ActorAttributes(json \ "actor_attributes")
      val created_at = n2ldt("created_at")
      val payload = GistEventPayload(json \ "payload")

      val params = Seq(actor, public, url, actor_attributes, created_at, payload)

      if(params.forall(_.isDefined))
         return Some(GistEvent(actor.get, public.get, url.get, actor_attributes.get, created_at.get, payload.get))
      else return None
   }
}

case class FollowEvent(actor: String, public: Boolean, created_at: LocalDateTime, payload: FollowEventPayload,
                       actor_attributes: ActorAttributes, url: String) extends GH2013Event

object FollowEvent
{
   def apply(json: JValue): Option[FollowEvent] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2b = gh3.node2Boolean(json)(_)
      val n2ldt = gh3.node2LocalDateTime(json)(_)

      val `type` = n2s("type")

      if(`type`.isEmpty || `type`.get != "FollowEvent") return None

      val actor = n2s("actor")
      val public = n2b("public")
      val created_at = n2ldt("created_at")
      val payload = FollowEventPayload(json \ "payload")
      val actor_attributes = ActorAttributes(json \ "actor_attributes")
      val url = n2s("url")

      val params = Seq(actor, public, created_at, payload, actor_attributes, url)

      if(params.forall(_.isDefined))
         Some(FollowEvent(actor.get, public.get, created_at.get, payload.get, actor_attributes.get, url.get))
      else None
   }
}

case class GollumEvent(event: EventBody, payload: GollumEventPayload) extends GH2013Event

case class CommitCommentEvent(event: EventBody, payload: CommitCommentEventPayload) extends GH2013Event

case class MemberEvent(event: EventBody, payload: MemberEventPayload) extends GH2013Event

case class DownloadEvent(event: EventBody, payload: DownloadEventPayload) extends GH2013Event

//case class ForkApplyEvent(event: EventBody, payload: ForkApplyEventPayload) extends GH2013Event

case class IssueCommentEvent(event: EventBody, payload: IssueCommentEventPayload) extends GH2013Event


