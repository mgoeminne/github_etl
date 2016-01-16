package gh3

import net.liftweb.json.JsonAST.JValue


case class GH3Base(
                     label: String,
                     ref: String,
                     sha: String,
                     user: GH3Sender,
                     repo: GH3Repository
                  )

object GH3Base
{
   def apply(json: JValue): Option[GH3Base] =
   {
      val n2s = node2String(json)(_)

      val label = n2s("label")
      val ref   = n2s("ref")
      val sha   = n2s("sha")
      val user = GH3Sender(json \ "user")
      val repo = GH3Repository(json \ "repo")

      if(Seq(label, ref, sha, user, repo).forall(_.isDefined))
         Some(new GH3Base(label.get, ref.get, sha.get, user.get, repo.get))
      else None
   }
}