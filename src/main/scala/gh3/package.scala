import gh3.events._
import net.liftweb.json.JsonAST._
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

package object gh3
{
   val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

   def node2String(node: JValue)(tag: String): Option[String] = directNode2String(node\tag)

   def directNode2String(node: JValue): Option[String] = node match {
      case JString(x) => Some(x)
      case _ => None
   }


   def node2OptionString(node: JValue)(tag: String): Option[Option[String]] =
   {
      (node\tag) match {
         case JString(x) => Some(Some(x))
         case JNull => Some(None)
         case JNothing => Some(None)
         case _ => None
      }
   }

   def node2LocalDateTime(node: JValue)(tag: String): Option[LocalDateTime] =
   {
      node2String(node)(tag).map(x => formatter.parseLocalDateTime(x.take(19)))
   }

   def node2OptionLocalDateTime(node: JValue)(tag: String): Option[Option[LocalDateTime]] =
   {
      (node\tag) match {
         case JNull => Some(None)
         case JString(d) => Some(Some(formatter.parseLocalDateTime(d.take(19))))
         case _ => None
      }
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

   def parse(event: JValue): Option[GH3Event] =
   {
      val parsers = Seq(CommitCommentEvent, CreateEvent, DeleteEvent, DeploymentEvent, DeploymentStatusEvent, ForkEvent,
         GollumEvent, IssueCommentEvent, IssuesEvent, MemberEvent, MembershipEvent, PageBuildEvent, PublicEvent,
         PullRequestEvent, PullRequestReviewCommentEvent, PushEvent, ReleaseEvent, RepositoryEvent, WatchEvent)

      //println(parsers.map(p => p(event)))

      parsers  .toStream
               .flatMap(parser => parser(event))
               .headOption
   }
}
