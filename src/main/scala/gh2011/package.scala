import gh2011.events._
import net.liftweb.json.JsonAST.JValue

package object gh2011
{
   def parse(event: JValue): Option[GH2011Event] =
   {
      val parsers = Seq(parser(PushEventParser)(_),
         parser(WatchEventParser)(_),
         parser(CreateEventParser)(_),
         parser(IssuesEventParser)(_),
         parser(ForkEventParser)(_),
         parser(PublicEventParser)(_),
         parser(PullRequestEventParser)(_),
         parser(DeleteEventParser)(_),
         parser(GistEventParser)(_),
         parser(FollowEventParser)(_),
         parser(GollumEventParser)(_),
         parser(CommitCommentEventParser)(_),
         parser(MemberEventParser)(_),
         parser(DownloadEventParser)(_)
      )

      //println(parsers.map(p => p(event)))

      parsers  .toStream
               .flatMap(parser => parser(event))
               .headOption
   }

   def parser[E,P](e: EventParser[E,P])(json: JValue): Option[GH2011Event] =
   {
      val `type` = gh3.node2String(json)("type")
      if(`type`.isEmpty || `type`.get != e.name) return None

      val event = GH2011EventBody(json)
      val payload = e.parsePayload(json \ "payload")

      if(event.isDefined && payload.isDefined) Some(e.make(event.get, payload.get))
      else None
   }
}
