package gh2011.events

import gh2011.models.{SimplifiedActor, Actor, Repository}
import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime

case class GH2011EventBody(val id: String, repo: Repository, created_at: LocalDateTime, actor: Either[Actor, SimplifiedActor])

object GH2011EventBody
{
   def apply(json: JValue): Option[GH2011EventBody] =
   {
      val id = gh3.node2String(json)("id")
      val repo = Repository(json \ "repo")
      val created_at = gh3.node2LocalDateTime(json)("created_at")
      val actor = Actor(json \ "actor") match {
         case Some(x) => Some(Left(x))
         case _ => SimplifiedActor(json \ "actor") match {
            case Some(y) => Some(Right(y))
            case _ => None
         }
      }

      val params = Seq(id, repo, created_at, actor)

      if(params.forall(_.isDefined))
         Some(GH2011EventBody(id.get, repo.get, created_at.get, actor.get))
      else None
   }
}