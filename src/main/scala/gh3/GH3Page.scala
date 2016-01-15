package gh3


case class GH3Page(  page_name: String,
                     title: String,
                     summary: Option[String],
                     action: String,
                     sha: String,
                     html_url: String)