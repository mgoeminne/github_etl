import gh2013.events._
import gh2013.models.EventBody
import net.liftweb.json.JsonAST.JValue

package object gh2013
{
   def parse(event: JValue): Option[GH2013Event] =
   {
      val parsers = Seq(
         parser(PushEventParser)(_),
         parser(WatchEventParser)(_),
         parser(CreateEventParser)(_),
         parser(IssuesEventParser)(_),
         parser(ForkEventParser)(_),
         PublicEventParser.parse(_),
         parser(PullRequestEventParser)(_),
         parser(DeleteEventParser)(_),
         GistEventParser.parse(_),
         FollowEventParser.parse(_),
         parser(GollumEventParser)(_),
         parser(CommitCommentEventParser)(_),
         parser(MemberEventParser)(_),
         parser(DownloadEventParser)(_),
       //  parser(ForkApplyEventParser)(_),
         parser(IssueCommentEventParser)(_)

      )

      //println(parsers.map(p => p(event)))

      parsers  .toStream
               .flatMap(parser => parser(event))
               .headOption
   }

   def parser[E,P](e: EventParser[E,P])(json: JValue): Option[GH2013Event] =
   {
      val `type` = gh3.node2String(json)("type")
      if(`type`.isEmpty || `type`.get != e.name) return None

      val event = EventBody(json)
      val payload = e.parsePayload(json \ "payload")

      if(event.isDefined && payload.isDefined) Some(e.make(event.get, payload.get))
      else None
   }
}
