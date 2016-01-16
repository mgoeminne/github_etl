package gh3

import net.liftweb.json.JsonAST.JValue
import org.joda.time.LocalDateTime


case class GH3Build(
                     url: String,
                     status: String,
                     error_message: Option[String],
                     pusher: GH3Sender,
                     commit: String,
                     duration: Long,
                     created_at: LocalDateTime,
                     updated_at: LocalDateTime
                   )

object GH3Build
{
   def apply(json: JValue): Option[GH3Build] =
   {
      val n2s = node2String(json)(_)
      val n2ldt = node2LocalDateTime(json)(_)

      val url = n2s("url")
      val status = n2s("status")
      val error_message = node2OptionString(json \ "error")("message")
      val pusher = GH3Sender(json \ "pusher")
      val commit = n2s("commit")
      val duration = node2Long(json)("duration")
      val created_at = n2ldt("created_at")
      val updated_at = n2ldt("updated_at")

      val params = Seq(url, status, error_message, pusher, commit, duration, created_at, updated_at)

      println(params.map(_.isDefined))
      if(params.forall(_.isDefined))
         Some(new GH3Build(url.get, status.get, error_message.get, pusher.get, commit.get, duration.get, created_at.get,
         updated_at.get))
      else None
   }
}
