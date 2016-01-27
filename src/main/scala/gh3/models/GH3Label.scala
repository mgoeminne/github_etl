package gh3.models

import gh3._
import net.liftweb.json.JsonAST.JValue


case class GH3Label( url: String,
                     name: String,
                     color: String)

object GH3Label
{
   def apply(json: JValue): Option[GH3Label] =
   {
      val n2s = node2String(json)(_)
      
      val url = n2s("url")
      val name = n2s("name")
      val color = n2s("color")

      if(Seq(url, name, color).forall(_.isDefined))
         Some(new GH3Label(url.get, name.get, color.get))
      else None
   }
}

