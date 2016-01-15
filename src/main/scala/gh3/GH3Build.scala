package gh3

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
