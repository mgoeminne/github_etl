package gh3


case class GH3Head(
                     label: String,
                     ref: String,
                     sha: String,
                     user: GH3Sender
                  )