package gh3.events

import gh3._
import gh3.models.{GH3Sender, GH3Repository, GH3Owner, GH3Commit}
import net.liftweb.json.JsonAST.{JArray, JValue}

case class PushEvent(
                       ref: String,
                       before: String,
                       after: String,
                       created: Boolean,
                       deleted: Boolean,
                       forced: Boolean,
                       base_ref: Option[String],
                       compare: String,
                       commits: Seq[GH3Commit],
                       head_commit: GH3Commit,
                       repository: GH3Repository,
                       pusher: GH3Owner,
                       sender: GH3Sender
                    ) extends GH3Event

object PushEvent extends GH3EventParser
{
   def apply(json: JValue): Option[PushEvent] =
   {
      val n2s = node2String(json)(_)
      val n2b = node2Boolean(json)(_)
      val n2os = node2OptionString(json)(_)

      val ref = n2s("ref")
      val before = n2s("before")
      val after = n2s("after")
      val created = n2b("created")
      val deleted = n2b("deleted")
      val forced = n2b("forced")
      val base_ref = n2os("base_ref")
      val compare = n2s("compare")
      val commits = (json \ "commits") match {
         case JArray(a) => Some(a.map(x => GH3Commit(x).get))
         case _ => None
      }
      val head_commit = GH3Commit(json \ "head_commit")
      val repository = GH3Repository(json \ "repository")
      val pusher = GH3Owner(json \ "pusher")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, before, after, created, deleted, forced, base_ref, compare, commits, head_commit, repository,
         pusher, sender)

      if(params.forall(_.isDefined))
         Some(new PushEvent(ref.get, before.get, after.get, created.get, deleted.get, forced.get, base_ref.get,
            compare.get, commits.get, head_commit.get, repository.get, pusher.get, sender.get))
      else None
   }
}
