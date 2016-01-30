package gh2013.models

import net.liftweb.json.JsonAST.JValue

case class Commit(repo: CommitRepository, label: String, sha: String, user: User, ref: String)

object Commit
{
   def apply(json: JValue): Option[Commit] =
   {
      val n2s = gh3.node2String(json)(_)

      val repo = CommitRepository(json \ "repo")
      val label = n2s("label")
      val sha = n2s("sha")
      val user = User(json \ "user")
      val ref = n2s("ref")

      val params = Seq(repo, label, sha, user, ref)

      if(params.forall(_.isDefined)) Some(Commit(repo.get, label.get, sha.get, user.get, ref.get))
      else None
   }
}
