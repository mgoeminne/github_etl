import gh.Main
import net.liftweb.json.JsonAST._
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by mg on 15/01/16.
  */
package object gh3
{
   val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

   def node2String(node: JValue)(tag: String): Option[String] =
   {
      (node\tag) match {
         case JString(x) => Some(x)
         case _ => None
      }
   }

   def node2OptionString(node: JValue)(tag: String): Option[Option[String]] =
   {
      (node\tag) match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case _ => None
      }
   }

   def node2LocalDateTime(node: JValue)(tag:String): Option[LocalDateTime] =
   {
      node2String(node)(tag).map(x => formatter.parseLocalDateTime(x.take(19)))
   }

   def node2Boolean(node: JValue)(tag:String): Option[Boolean] =
   {
      (node\tag) match {
         case JBool(x) => Some(x)
         case _ => None
      }
   }

   def node2Long(node: JValue)(tag: String): Option[Long] =
   {
      (node\tag) match {
         case JInt(x) => Some(x.toLong)
         case _ => None
      }
   }
}
