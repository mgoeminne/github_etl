package gh2011c.models

import net.liftweb.json.JsonAST.JValue

case class IssuesEventPayload(number: Long, issue: Long, action: String)

object IssuesEventPayload
{
   def apply(json: JValue): Option[IssuesEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val number = n2l("number")
      val issue = n2l("issue")
      val action = n2s("action")

      val params = Seq(number, issue, action)

      if(params.forall(_.isDefined)) Some(IssuesEventPayload(number.get, issue.get, action.get))
      else None
   }
}
