package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class IssuesEventPayload(number: Long, action: String, issue: Long)

object IssuesEventPayload
{
   def apply(json: JValue): Option[IssuesEventPayload] =
   {
      val n2l = gh3.node2Long(json)(_)

      val number = n2l("number")
      val action = gh3.node2String(json)("action")
      val issue = n2l("issue")

      val params = Seq(number, action, issue)

      if(params.forall(_.isDefined)) Some(IssuesEventPayload(number.get, action.get, issue.get))
      else None
   }
}
