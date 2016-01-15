package gh3

import org.joda.time.LocalDateTime


case class GH3Release(
                        url: String,
                        assets_url: String,
                        upload_url: String,
                        html_url: String,
                        id: Long,
                        tag_name: String,
                        target_commitish: String,
                        name: Option[String],
                        draft: Boolean,
                        author: GH3Sender,
                        prerelease: Boolean,
                        created_at: LocalDateTime,
                        published_at: LocalDateTime,
                        assets: Seq[String],
                        tarball_url: String,
                        zipball_url: String,
                        body: Option[String]
                     )