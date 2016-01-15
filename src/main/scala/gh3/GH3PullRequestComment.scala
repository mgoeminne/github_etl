package gh3

import org.joda.time.LocalDateTime

case class GH3PullRequestComment(
                                 url: String,
                                 id: Long,
                                 diff_hunk: String,
                                 path: String,
                                 position: Int,
                                 original_position: Int,
                                 commit_id: String,
                                 original_commit_id: String,
                                 user: GH3Sender,
                                 body: String,
                                 created_at: LocalDateTime,
                                 updated_at: LocalDateTime,
                                 html_url: String,
                                 self_link: String,
                                 html_link: String,
                                 pull_request_link: String
                                )
