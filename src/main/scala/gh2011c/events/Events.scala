package gh2011c.events

import gh2011.events.GH2011EventBody
import gh2011c.models._

case class IssueCommentEvent(event: GH2011EventBody, payload: IssueCommentEventPayload) extends GH2011cEvent




