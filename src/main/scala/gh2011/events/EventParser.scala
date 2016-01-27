package gh2011.events

import net.liftweb.json.JsonAST.JValue

trait EventParser
{
   def apply(json: JValue): Option[gh2011.events.Event]
}
