package gh2011b.models

import net.liftweb.json.JsonAST.{JArray, JValue}


case class BasicEventPayload(shas: Seq[Seq[Option[String]]], repo: String, actor: String, ref: String, size: Long,
                             head: String, actor_gravatar: String, push_id: Long)

object BasicEventPayload
{
   def apply(json: JValue): Option[BasicEventPayload] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)
      val n2os = gh3.node2OptionString(json)(_)


      val shas = (json \ "shas") match {
         case JArray(x) => x.map(e => e match {
            case JArray(y) => y.map(f => gh3.directNode2OptionString(f).get)
            case _ => Seq()
         })
         case _ => Seq()
      }

      val repo = n2s("repo")
      val actor = n2s("actor")
      val ref = n2s("ref")
      val size = n2l("size")
      val head = n2s("head")
      val actor_gravatar = n2s("actor_gravatar")
      val push_id = n2l("push_id")

      val params = Seq(repo, actor, ref, size, head, actor_gravatar, push_id)

      if(params.forall(_.isDefined))
         Some(BasicEventPayload(shas, repo.get, actor.get, ref.get, size.get, head.get, actor_gravatar.get,
            push_id.get))
      else None
   }
}
