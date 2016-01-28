package gh2011.events

import gh2011.models._
import net.liftweb.json.JsonAST.JValue

abstract class EventParser[E, P](val name: String)
{
   def parsePayload(json: JValue): Option[P]
   def make(event: GH2011EventBody, payload: P): GH2011Event
}

object PushEventParser extends EventParser[PushEvent, PushEventPayload]("PushEvent")
{
   override def parsePayload(json: JValue): Option[PushEventPayload] = PushEventPayload(json)

   override def make(event: GH2011EventBody, payload: PushEventPayload): PushEvent = PushEvent(event, payload)
}

object WatchEventParser extends EventParser[WatchEvent, WatchEventPayload]("WatchEvent")
{
   override def parsePayload(json: JValue): Option[WatchEventPayload] = WatchEventPayload(json)

   override def make(event: GH2011EventBody, payload: WatchEventPayload): GH2011Event = WatchEvent(event, payload)
}

object CreateEventParser extends EventParser[CreateEvent, CreateEventPayload]("CreateEvent")
{
   override def parsePayload(json: JValue): Option[CreateEventPayload] = CreateEventPayload(json)

   override def make(event: GH2011EventBody, payload: CreateEventPayload): GH2011Event = CreateEvent(event, payload)
}

object IssuesEventParser extends EventParser[IssueEvent, IssuesEventPayload]("IssuesEvent")
{
   override def parsePayload(json: JValue): Option[IssuesEventPayload] = IssuesEventPayload(json)

   override def make(event: GH2011EventBody, payload: IssuesEventPayload): GH2011Event = IssueEvent(event, payload)
}

object ForkEventParser extends EventParser[ForkEvent, ForkEventPayload]("ForkEvent")
{
   override def parsePayload(json: JValue): Option[ForkEventPayload] = ForkEventPayload(json)

   override def make(event: GH2011EventBody, payload: ForkEventPayload): GH2011Event = ForkEvent(event, payload)
}

object PublicEventParser extends EventParser[PublicEvent, PublicEventPayload]("PublicEvent")
{
   override def parsePayload(json: JValue): Option[PublicEventPayload] = PublicEventPayload(json)

   override def make(event: GH2011EventBody, payload: PublicEventPayload): GH2011Event = PublicEvent(event, payload)
}
