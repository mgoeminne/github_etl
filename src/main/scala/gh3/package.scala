import gh.Main
import net.liftweb.json.JsonAST._
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by mg on 15/01/16.
  */
package object gh3
{
   private val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

   def node2String(node: JValue): Option[String] =
   {
      node match {
         case JString(x) => Some(x)
         case _ => None
      }
   }

   def node2OptionString(node: JValue): Option[Option[String]] =
   {
      node match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case _ => None
      }
   }

   def node2LocalDateTime(node: JValue): Option[LocalDateTime] =
   {
      node2String(node).map(x => formatter.parseLocalDateTime(x.take(19)))
   }

   def node2Boolean(node: JValue): Option[Boolean] =
   {
      node match {
         case JBool(x) => Some(x)
         case _ => None
      }
   }

   def node2Long(node: JValue): Option[Long] =
   {
      node match {
         case JInt(x) => Some(x.toLong)
         case _ => None
      }
   }



}
