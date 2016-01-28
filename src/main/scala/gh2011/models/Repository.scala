package gh2011.models

import net.liftweb.json.JsonAST.JValue

case class Repository(url: String, name: String)

object Repository
{
   def apply(json: JValue): Option[Repository] =
   {
      val n2l = gh3.node2Long(json)(_)
      val n2s = gh3.node2String(json)(_)

      val url = n2s("url")
      val name = n2s("name")

      if(Seq(url, name).forall(_.isDefined))
         Some(Repository(url.get, name.get))
      else None
   }
}
