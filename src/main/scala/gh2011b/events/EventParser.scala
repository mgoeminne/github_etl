package gh2011b.events

import gh2011.events.GH2011EventBody
import gh2011b.models._
import net.liftweb.json.JsonAST.JValue

abstract class EventParser[E, P](val name: String)
{
   def parsePayload(json: JValue): Option[P]
   def make(event: GH2011EventBody, payload: P): GH2011bEvent
}

object PushEventParser extends EventParser[PushEvent, PushEventPayload]("PushEvent")
{
   override def parsePayload(json: JValue): Option[PushEventPayload] = PushEventPayload(json)

   override def make(event: GH2011EventBody, payload: PushEventPayload): PushEvent = PushEvent(event, payload)
}

object WatchEventParser extends EventParser[WatchEvent, WatchEventPayload]("WatchEvent")
{
   override def parsePayload(json: JValue): Option[WatchEventPayload] = WatchEventPayload(json)

   override def make(event: GH2011EventBody, payload: WatchEventPayload): GH2011bEvent = WatchEvent(event, payload)
}

object CreateEventParser extends EventParser[CreateEvent, CreateEventPayload]("CreateEvent")
{
   override def parsePayload(json: JValue): Option[CreateEventPayload] = CreateEventPayload(json)

   override def make(event: GH2011EventBody, payload: CreateEventPayload): GH2011bEvent = CreateEvent(event, payload)
}

object IssuesEventParser extends EventParser[IssueEvent, IssuesEventPayload]("IssuesEvent")
{
   override def parsePayload(json: JValue): Option[IssuesEventPayload] = IssuesEventPayload(json)

   override def make(event: GH2011EventBody, payload: IssuesEventPayload): GH2011bEvent = IssueEvent(event, payload)
}

object ForkEventParser extends EventParser[ForkEvent, ForkEventPayload]("ForkEvent")
{
   override def parsePayload(json: JValue): Option[ForkEventPayload] = ForkEventPayload(json)

   override def make(event: GH2011EventBody, payload: ForkEventPayload): GH2011bEvent = ForkEvent(event, payload)
}

object PublicEventParser extends EventParser[PublicEvent, PublicEventPayload]("PublicEvent")
{
   override def parsePayload(json: JValue): Option[PublicEventPayload] = PublicEventPayload(json)

   override def make(event: GH2011EventBody, payload: PublicEventPayload): GH2011bEvent = PublicEvent(event, payload)
}

object PullRequestEventParser extends EventParser[PullRequestEvent, PullRequestEventPayload]("PullRequestEvent")
{
   override def parsePayload(json: JValue): Option[PullRequestEventPayload] = PullRequestEventPayload(json)

   override def make(event: GH2011EventBody, payload: PullRequestEventPayload): GH2011bEvent = PullRequestEvent(event, payload)
}

object DeleteEventParser extends EventParser[DeleteEvent, DeleteEventPayload]("DeleteEvent")
{
   override def parsePayload(json: JValue): Option[DeleteEventPayload] = DeleteEventPayload(json)

   override def make(event: GH2011EventBody, payload: DeleteEventPayload): GH2011bEvent = DeleteEvent(event, payload)
}

object GistEventParser extends EventParser[GistEvent, GistEventPayload]("GistEvent")
{
   override def parsePayload(json: JValue): Option[GistEventPayload] = GistEventPayload(json)

   override def make(event: GH2011EventBody, payload: GistEventPayload): GH2011bEvent = GistEvent(event, payload)
}

object FollowEventParser extends EventParser[FollowEvent, FollowEventPayload]("FollowEvent")
{
   override def parsePayload(json: JValue): Option[FollowEventPayload] = FollowEventPayload(json)

   override def make(event: GH2011EventBody, payload: FollowEventPayload): GH2011bEvent = FollowEvent(event, payload)
}

object GollumEventParser extends EventParser[GollumEvent, GollumEventPayload]("GollumEvent")
{
   override def parsePayload(json: JValue): Option[GollumEventPayload] = GollumEventPayload(json)

   override def make(event: GH2011EventBody, payload: GollumEventPayload): GH2011bEvent = GollumEvent(event, payload)
}

object MultiGollumEventParser extends EventParser[MultiGollumEvent, MultiGollumEventPayload]("GollumEvent")
{
   override def parsePayload(json: JValue): Option[MultiGollumEventPayload] = MultiGollumEventPayload(json)

   override def make(event: GH2011EventBody, payload: MultiGollumEventPayload): GH2011bEvent = MultiGollumEvent(event, payload)
}


object CommitCommentEventParser extends EventParser[CommitCommentEvent, CommitCommentEventPayload]("CommitCommentEvent")
{
   override def parsePayload(json: JValue): Option[CommitCommentEventPayload] = CommitCommentEventPayload(json)

   override def make(event: GH2011EventBody, payload: CommitCommentEventPayload): GH2011bEvent = CommitCommentEvent(event, payload)
}

object MemberEventParser extends EventParser[MemberEvent, MemberEventPayload]("MemberEvent")
{
   override def parsePayload(json: JValue): Option[MemberEventPayload] = MemberEventPayload(json)

   override def make(event: GH2011EventBody, payload: MemberEventPayload): GH2011bEvent = MemberEvent(event, payload)
}

object DownloadEventParser extends EventParser[DownloadEvent, DownloadEventPayload]("DownloadEvent")
{
   override def parsePayload(json: JValue): Option[DownloadEventPayload] = DownloadEventPayload(json)

   override def make(event: GH2011EventBody, payload: DownloadEventPayload): GH2011bEvent = DownloadEvent(event, payload)
}

object ForkApplyEventParser extends EventParser[ForkApplyEvent, ForkApplyEventPayload]("ForkApplyEvent")
{
   override def parsePayload(json: JValue): Option[ForkApplyEventPayload] = ForkApplyEventPayload(json)

   override def make(event: GH2011EventBody, payload: ForkApplyEventPayload): GH2011bEvent = ForkApplyEvent(event, payload)
}

object IssueCommentEventParser extends EventParser[IssueCommentEvent, IssueCommentEventPayload]("IssueCommentEvent")
{
   override def parsePayload(json: JValue): Option[IssueCommentEventPayload] = IssueCommentEventPayload(json)

   override def make(event: GH2011EventBody, payload: IssueCommentEventPayload): GH2011bEvent = IssueCommentEvent(event, payload)
}


