package gh2011.events

import gh2011.models.{CreateEventPayload, WatchEventPayload, PushEventPayload}

case class PushEvent(event: GH2011EventBody, payload: PushEventPayload) extends GH2011Event

case class WatchEvent(event: GH2011EventBody, payload: WatchEventPayload) extends GH2011Event

case class CreateEvent(event: GH2011EventBody, payload: CreateEventPayload) extends GH2011Event

