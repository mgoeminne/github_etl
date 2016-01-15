package gh3


case class GH3Base(
                     label: String,
                     ref: String,
                     sha: String,
                     user: GH3Sender,
                     repo: GH3Repository
                  )