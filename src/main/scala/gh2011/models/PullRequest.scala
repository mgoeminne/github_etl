package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class PullRequest(title: String, number: Long, commits: Long, deletions: Long, id: Long, issue_id: Long,
                       additions: Long)

object PullRequest
{
   def apply(json: JValue): Option[PullRequest] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val title = n2s("title")
      val number = n2l("number")
      val commits = n2l("commits")
      val deletions = n2l("deletions")
      val id = n2l("id")
      val issue_id = n2l("issue_id")
      val additions = n2l("additions")

      val params = Seq(title, number, commits, deletions, id, issue_id, additions)

      if(params.forall(_.isDefined))
         Some(PullRequest(title.get, number.get, commits.get, deletions.get, id.get, issue_id.get, additions.get))
      else None
   }
}