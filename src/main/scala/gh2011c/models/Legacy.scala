package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class Legacy(issue_id: Long, comment_id: Long)

object Legacy
{
   def apply(json: JValue): Option[Legacy] =
   {
      val n2l = gh3.node2Long(json)(_)

      val issue_id = n2l("issue_id")
      val comment_id = n2l("comment_id")

      val params = Seq(issue_id, comment_id)

      if(params.forall(_.isDefined)) Some(Legacy(issue_id.get, comment_id.get))
      else None
   }
}