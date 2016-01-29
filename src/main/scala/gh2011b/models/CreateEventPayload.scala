package gh2011b.models

import net.liftweb.json.JsonAST.JValue


case class CreateEventPayload(ref: Option[String], ref_type: String, description: String, master_branch: String)

object CreateEventPayload
{
   def apply(json: JValue): Option[CreateEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2os = gh3.node2OptionString(json)(_)

      val ref = n2os("ref")
      val ref_type = n2s("ref_type")
      val description = n2s("description")
      val master_branch = n2s("master_branch")

      val params = Seq(ref, ref_type, description, master_branch)

      if(params.forall(_.isDefined)) Some(CreateEventPayload(ref.get, ref_type.get, description.get, master_branch.get))
      else None
   }
}
