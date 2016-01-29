package gh2011b.events

import gh2011.events.GH2011EventBody
import gh2011b.models._

case class PushEvent(event: GH2011EventBody, payload: PushEventPayload) extends GH2011bEvent

case class WatchEvent(event: GH2011EventBody, payload: WatchEventPayload) extends GH2011bEvent

case class CreateEvent(event: GH2011EventBody, payload: CreateEventPayload) extends GH2011bEvent

case class IssueEvent(event: GH2011EventBody, payload: IssuesEventPayload) extends GH2011bEvent

case class ForkEvent(event: GH2011EventBody, payload: ForkEventPayload) extends GH2011bEvent

case class PublicEvent(event: GH2011EventBody, payload: PublicEventPayload) extends GH2011bEvent

case class PullRequestEvent(event: GH2011EventBody, payload: PullRequestEventPayload) extends GH2011bEvent

case class DeleteEvent(event: GH2011EventBody, payload: DeleteEventPayload) extends GH2011bEvent

case class GistEvent(event: GH2011EventBody, payload: GistEventPayload) extends GH2011bEvent

case class FollowEvent(event: GH2011EventBody, payload: FollowEventPayload) extends GH2011bEvent

case class GollumEvent(event: GH2011EventBody, payload: GollumEventPayload) extends GH2011bEvent

case class MultiGollumEvent(event: GH2011EventBody, payload: MultiGollumEventPayload) extends GH2011bEvent

case class CommitCommentEvent(event: GH2011EventBody, payload: CommitCommentEventPayload) extends GH2011bEvent

case class MemberEvent(event: GH2011EventBody, payload: MemberEventPayload) extends GH2011bEvent

case class DownloadEvent(event: GH2011EventBody, payload: DownloadEventPayload) extends GH2011bEvent

case class ForkApplyEvent(event: GH2011EventBody, payload: ForkApplyEventPayload) extends GH2011bEvent

case class IssueCommentEvent(event: GH2011EventBody, payload: IssueCommentEventPayload) extends GH2011bEvent

case class BasicEvent(event: GH2011EventBody, payload: BasicEventPayload) extends GH2011bEvent





