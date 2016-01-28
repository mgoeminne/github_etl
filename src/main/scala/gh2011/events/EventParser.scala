package gh2011.events

import gh2011.models.{CreateEventPayload, WatchEventPayload, PushEventPayload}
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
