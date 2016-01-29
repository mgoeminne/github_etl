import gh2011.events.GH2011EventBody
import gh2011c.events._
import net.liftweb.json.JsonAST.JValue

package object gh2011c
{
   def parse(event: JValue): Option[GH2011cEvent] =
   {
      val parsers = Seq(
        parser(IssueCommentEventParser)(_))

      //println(parsers.map(p => p(event)))

      parsers  .toStream
         .flatMap(parser => parser(event))
         .headOption
   }

   def parser[E,P](e: EventParser[E,P])(json: JValue): Option[GH2011cEvent] =
   {
      val `type` = gh3.node2String(json)("type")

      if(`type`.isEmpty || `type`.get != e.name) return None

      val event = GH2011EventBody(json)
      val payload = e.parsePayload(json \ "payload")

      if(event.isDefined && payload.isDefined) Some(e.make(event.get, payload.get))
      else None
   }
}
