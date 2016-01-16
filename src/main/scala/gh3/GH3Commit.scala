package gh3

import net.liftweb.json.JsonAST.{JArray, JValue}
import org.joda.time.LocalDateTime

case class GH3Commit(   id: String,
                        distinct: Boolean,
                        message: String,
                        timestamp: LocalDateTime,
                        url: String,
                        author: Contributor,
                        committer: Contributor,
                        added: Seq[String],
                        removed: Seq[String],
                        modified: Seq[String]
                    )

object GH3Commit
{
   def apply(json: JValue): Option[GH3Commit] =
   {
      val n2s = node2String(json)(_)

      val id = n2s("id")
      val distinct = node2Boolean(json)("distinct")
      val message = n2s("message")
      val timestamp = node2LocalDateTime(json)("timestamp")
      val url = n2s("url")
      val author = Contributor(json \ "author")
      val committer = Contributor(json \ "committer")
      val added = (json \ "added") match {
         case JArray(x) => Some(x.map(directNode2String(_).get))
         case _ => None
      }
      val removed = (json \ "removed") match {
         case JArray(x) => Some(x.map(directNode2String(_).get))
         case _ => None
      }

      val modified = (json \ "modified") match {
         case JArray(x) => Some(x.map(directNode2String(_).get) )
         case _ => None
      }

      val params = Seq(id, distinct, message, timestamp, url, author, committer, added, removed, modified)

      if(params.forall(_.isDefined))
         Some(new GH3Commit(id.get, distinct.get, message.get, timestamp.get, url.get, author.get, committer.get,
            added.get, removed.get, modified.get))
      else None
   }
}
