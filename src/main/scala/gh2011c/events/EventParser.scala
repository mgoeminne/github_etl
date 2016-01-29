package gh2011c.events

import gh2011.events.GH2011EventBody
import gh2011c.models._
import net.liftweb.json.JsonAST.JValue

abstract class EventParser[E, P](val name: String)
{
   def parsePayload(json: JValue): Option[P]
   def make(event: GH2011EventBody, payload: P): GH2011cEvent
}

object IssueCommentEventParser extends EventParser[IssueCommentEvent, IssueCommentEventPayload]("IssueCommentEvent")
{
   override def parsePayload(json: JValue): Option[IssueCommentEventPayload] = IssueCommentEventPayload(json)

   override def make(event: GH2011EventBody, payload: IssueCommentEventPayload): GH2011cEvent = IssueCommentEvent(event, payload)
}


