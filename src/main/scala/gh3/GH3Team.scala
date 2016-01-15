package gh3


case class GH3Team(
                     name: String,
                     id: Long,
                     slug: String,
                     permission: String,
                     url: String,
                     members_url: String,
                     repositories_url: String
                  )