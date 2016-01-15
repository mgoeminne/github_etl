package gh3

import net.liftweb.json.JsonAST.JValue


case class GH3Label( url: String,
                     name: String,
                     color: String)

object GH3Label
{
   def apply(json: JValue): Option[GH3Label] =
   {
      val url = node2String(json \ "url")
      val name = node2String(json \ "name")
      val color = node2String(json \ "color")

      if(Seq(url, name, color).forall(_.isDefined))
         Some(new GH3Label(url.get, name.get, color.get))
      else None
   }
}

