package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class SimplifiedActor(url: String, avatar_url: String)

object SimplifiedActor
{
   def apply(json: JValue): Option[SimplifiedActor] =
   {
      val n2s = gh3.node2String(json)(_)
      val n2l = gh3.node2Long(json)(_)

      val url = n2s("url")
      val avatar_url = n2s("avatar_url")

      val params = Seq(url, avatar_url)

      if(params.forall(_.isDefined))
         Some(SimplifiedActor(url.get, avatar_url.get))
      else None
   }
}