package gh3.events

import net.liftweb.json.JsonAST.{JValue, JObject}


trait GH3EventParser
{
   def apply(event: JValue): Option[GH3Event]
}
