import gh2011.events.{PushEvent, Event}
import net.liftweb.json.JsonAST.JValue

package object gh2011
{
   def parse(event: JValue): Option[Event] =
   {
      val parsers = Seq(PushEvent)

      println(parsers.map(p => p(event)))

      parsers  .toStream
         .flatMap(parser => parser(event))
         .headOption
   }
}
