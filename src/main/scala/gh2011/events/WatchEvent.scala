package gh2011.events


import gh2011.models.WatchEventPayload

case class WatchEvent(  event: GH2011EventBody,
                        payload: WatchEventPayload) extends GH2011Event

