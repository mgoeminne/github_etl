package gh2011.events

import gh2011.models._

case class PushEvent(event: GH2011EventBody, payload: PushEventPayload) extends GH2011Event

case class WatchEvent(event: GH2011EventBody, payload: WatchEventPayload) extends GH2011Event

case class CreateEvent(event: GH2011EventBody, payload: CreateEventPayload) extends GH2011Event

case class IssueEvent(event: GH2011EventBody, payload: IssuesEventPayload) extends GH2011Event

case class ForkEvent(event: GH2011EventBody, payload: ForkEventPayload) extends GH2011Event

case class PublicEvent(event: GH2011EventBody, payload: PublicEventPayload) extends GH2011Event

case class PullRequestEvent(event: GH2011EventBody, payload: PullRequestEventPayload) extends GH2011Event

