package gh3

import org.joda.time.LocalDateTime

/**
  * Created by mg on 14/01/16.
  */
case class GH3Issue(
                     url: String,
                     labels_url: String,
                     comments_url: String,
                     events_url: String,
                     html_url: String,
                     id: Long,
                     number: Long,
                     title: String,
                     user: GH3Sender,
                     labels: Seq[GH3Label],
                     state: String,
                     locked: Boolean,
                     assignee: Option[String],
                     milestone: Option[String],
                     comments: Long,
                     created_at: LocalDateTime,
                     updated_at: LocalDateTime,
                     closed_at: Option[LocalDateTime],
                     body: String
                   )
