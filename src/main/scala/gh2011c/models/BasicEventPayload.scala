package gh2011c.models

import net.liftweb.json.JsonAST.{JArray, JValue}


case class BasicEventPayload(repo: String, actor: String, actor_gravatar: String)

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
      val actor_gravatar = n2s("actor_gravatar")

      val params = Seq(repo, actor, actor_gravatar)

      if(params.forall(_.isDefined)) Some(BasicEventPayload(repo.get, actor.get, actor_gravatar.get))
      else None
   }
}
