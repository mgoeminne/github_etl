package gh3.models

import gh3._
import net.liftweb.json.JsonAST.JValue


case class GH3Head(
                     label: String,
                     ref: String,
                     sha: String,
                     user: GH3Sender,
                     repo: GH3Repository
                  )

object GH3Head
{
   def apply(json: JValue): Option[GH3Head] =
   {
      val n2s = node2String(json)(_)

      val label  = n2s("label")
      val ref = n2s("ref")
      val sha = n2s("sha")
      val user = GH3Sender(json \ "user")
      val repo = GH3Repository(json \ "repo")

      if(Seq(label, ref, sha, user).forall(_.isDefined))
         Some(new GH3Head(label.get, ref.get, sha.get, user.get, repo.get))
      else None
   }
}