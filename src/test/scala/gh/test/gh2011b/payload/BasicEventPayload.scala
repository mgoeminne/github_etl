package gh.test.gh2011b.payload

import gh2011b.models.{BasicEventPayload, CommitCommentEventPayload}
import net.liftweb.json._
import org.scalatest.{Matchers, FlatSpec}

class BasicEventPayloadTest extends FlatSpec with Matchers
{
   "A valid BasicEvent payload" must "be correctly parsed" in {
      val json = parse(
         """
           | {
           |
           |    "shas":[
           |        [
           |            "fd57b963ad3e43cc1d7c6a5bad87d9342d9038e0",
           |            "kumpera@gmail.com",
           |            "Implement a reference queue API.\n\n\t* gc.c: A reference queue allows one to queue\n\tcallbcks for when objects are collected.\n\tIt allows for safe cleanup of objects that can\n\tonly be done when it is effectively collected.\n\tThe major difference with regular finalization\n\tis that the collector makes sure the object\n\twas collected - and can't be resurrected.\n\n\t* gc-internal.h: Export entrypoints for the\n\tnew API.",
           |            "Rodrigo Kumpera"
           |        ],
           |        [
           |            "e7785a27abfc1d09940a9a0439961095362757a0",
           |            "kumpera@gmail.com",
           |            "Don't use finalization to cleanup dynamic methods.\n\n\t* reflection.c: Use a reference queue to cleanup\n\tdynamic methods instead of finalization.\n\n\t* runtime.c: Shutdown the dynamic method queue\n\tbefore runtime cleanup begins.\n\n\t* DynamicMethod.cs: No longer finalizable.\n\n\t* icall-def.h: Remove unused dynamic method icall.\n\n\tFixes #660422",
           |            "Rodrigo Kumpera"
           |        ]
           |    ],
           |    "repo":"mono/mono",
           |    "actor":"kumpera",
           |    "ref":"refs/heads/mono-2-10",
           |    "size":2,
           |    "head":"e7785a27abfc1d09940a9a0439961095362757a0",
           |    "actor_gravatar":"2e67d0b9557bce18c5e6347ab4b8643e",
           |    "push_id":23942887
           |
           |}
         """.stripMargin)

      BasicEventPayload(json) shouldBe 'defined
   }
}
