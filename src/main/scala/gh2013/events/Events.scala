package gh2013.events

import gh2013.payloads._

case class PushEvent(event: EventBody, payload: PushEventPayload) extends GH2013Event

case class WatchEvent(event: EventBody, payload: WatchEventPayload) extends GH2013Event

//case class CreateEvent(event: EventBody, payload: CreateEventPayload) extends GH2013Event

case class IssuesEvent(event: EventBody, payload: IssuesEventPayload) extends GH2013Event

//case class ForkEvent(event: EventBody, payload: ForkEventPayload) extends GH2013Event

//case class PublicEvent(event: EventBody, payload: PublicEventPayload) extends GH2013Event

//case class PullRequestEvent(event: EventBody, payload: PullRequestEventPayload) extends GH2013Event

//case class DeleteEvent(event: EventBody, payload: DeleteEventPayload) extends GH2013Event

//case class GistEvent(event: EventBody, payload: GistEventPayload) extends GH2013Event

case class FollowEvent(event: EventBody, payload: FollowEventPayload) extends GH2013Event

//case class GollumEvent(event: EventBody, payload: GollumEventPayload) extends GH2013Event

//case class CommitCommentEvent(event: EventBody, payload: CommitCommentEventPayload) extends GH2013Event

//case class MemberEvent(event: EventBody, payload: MemberEventPayload) extends GH2013Event

//case class DownloadEvent(event: EventBody, payload: DownloadEventPayload) extends GH2013Event

//case class ForkApplyEvent(event: EventBody, payload: ForkApplyEventPayload) extends GH2013Event

//case class IssueCommentEvent(event: EventBody, payload: IssueCommentEventPayload) extends GH2013Event