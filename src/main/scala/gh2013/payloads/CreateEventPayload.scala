package gh2013.payloads

import net.liftweb.json.JsonAST.JValue

case class CreateEventPayload(ref: Option[String], description: String, ref_type: String, master_branch: String)

object CreateEventPayload
{
   def apply(json: JValue): Option[CreateEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val ref = n2os("ref")
      val description = n2s("description")
      val ref_type = n2s("ref_type")
      val master_branch = n2s("master_branch")

      val params = Seq(ref, description, ref_type, master_branch)

      if(params.forall(_.isDefined)) Some(CreateEventPayload(ref.get, description.get, ref_type.get, master_branch.get))
      else None
   }
}