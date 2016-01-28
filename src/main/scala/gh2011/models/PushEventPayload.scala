package gh2011.models

import net.liftweb.json.JsonAST.{JArray, JValue}

case class PushEventPayload(shas: Seq[SHA], repo: String, actor: String,
                            ref: String, size: Long, head: String, actor_gravatar: String, push_id: Long)

object PushEventPayload
{
   def apply(json: JValue): Option[PushEventPayload] =
   {
      def n2s = gh3.node2String(json)(_)
      def n2l = gh3.node2Long(json)(_)

      def shas = (json \ "shas") match {
         case JArray(x) => Some(x map (e => SHA(gh3.directNode2String(e(0)).get,
                                                gh3.directNode2String(e(1)).get,
                                                gh3.directNode2String(e(2)).get)))
         case _ => Some(Seq())
      }

      def repo = n2s("repo")
      def actor = n2s("actor")
      def ref = n2s("ref")
      def size = n2l("size")
      def head = n2s("head")
      def actor_gravatar = n2s("actor_gravatar")
      def push_id = n2l("push_id")

      val params = Seq(shas, repo, actor, ref, size, head, actor_gravatar, push_id)

      if(params.forall(_.isDefined))
         Some(PushEventPayload(shas.get, repo.get, actor.get, ref.get, size.get, head.get, actor_gravatar.get, push_id.get))
      else None
   }
}

