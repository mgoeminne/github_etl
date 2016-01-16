package gh3

import net.liftweb.json.JsonAST.JValue

case class GH3Organization(
                           login: String,
                           id: Long,
                           url: String,
                           repos_url: String,
                           events_url: String,
                           members_url: String,
                           public_members_url: String,
                           avatar_url: String
                          )

object GH3Organization
{
   def apply(json: JValue): Option[GH3Organization] =
   {
      None
   }
}
