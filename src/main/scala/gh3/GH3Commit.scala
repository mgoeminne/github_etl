package gh3

import org.joda.time.LocalDateTime

case class GH3Commit(   id: String,
                        distinct: Boolean,
                        message: String,
                        timestamp: LocalDateTime,
                        url: String,
                        author: Contributor,
                        committer: Contributor,
                        added: Seq[String],
                        removed: Seq[String],
                        modified: Seq[String]
                    )
