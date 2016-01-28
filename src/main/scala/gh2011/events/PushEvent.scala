package gh2011.events

import gh2011.models._

case class PushEvent(gH2011Event: GH2011EventBody, payload: PushEventPayload) extends GH2011Event
