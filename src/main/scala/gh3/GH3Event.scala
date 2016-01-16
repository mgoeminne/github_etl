package gh3

import net.liftweb.json.JsonAST.{JArray, JValue}

sealed class GH3Event


case class CommitCommentEvent(
                                action: String,
                                comment: GH3CommitComment,
                                repository: GH3Repository,
                                sender: GH3Sender
                             ) extends GH3Event

object CommitCommentEvent{
   def apply(json: JValue): Option[CommitCommentEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val comment = GH3CommitComment(json \ "comment")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if (Seq(action, comment, repository, sender).forall(_.isDefined))
         Some(new CommitCommentEvent(action.get, comment.get, repository.get, sender.get))
      else None
   }
}

case class CreateEvent (
                        ref: String,
                        ref_type: String,
                        master_branch: String,
                        description: String,
                        pusher_type: String,
                        repository: GH3Repository,
                        sender: GH3Sender

                       ) extends GH3Event

object CreateEvent
{
   def apply(json: JValue): Option[CreateEvent] =
   {
      val n2s = node2String(json)(_)
      
      val ref = n2s("ref")
      val ref_type = n2s("ref_type")
      val master_branch = n2s("master_branch")
      val description = n2s("description")
      val pusher_type = n2s("pusher_type")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, ref_type, master_branch, description, pusher_type, repository, sender)

      if(params.forall(_.isDefined))
         Some(new CreateEvent(ref.get, ref_type.get, master_branch.get, description.get, pusher_type.get,
                              repository.get, sender.get))
      else None
   }
}


case class DeleteEvent(
                        ref: String,
                        ref_type: String,
                        pusher_type: String,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object DeleteEvent
{
   def apply(json: JValue): Option[DeleteEvent] =
   {
      val n2s = node2String(json)(_)

      val ref = n2s("ref")
      val ref_type = n2s("ref_type")
      val pusher_type = n2s("pusher_type")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, ref_type, pusher_type, repository, sender)

      if(params.forall(_.isDefined))
         Some(new DeleteEvent(ref.get, ref_type.get, pusher_type.get, repository.get, sender.get))
      else None
   }
}


case class DeploymentEvent(
                              deployment: GH3Deployment,
                              repository: GH3Repository,
                              sender: GH3Sender
                           ) extends GH3Event

object DeploymentEvent
{
   def apply(json: JValue): Option[DeploymentEvent] =
   {
      val deployment = GH3Deployment(json \ "deployment")
      val repository = GH3Repository(json \ "repository")
      val sender     = GH3Sender(json \ "sender")

      if(Seq(deployment, repository, sender).forall(_.isDefined))
         Some(new DeploymentEvent(deployment.get, repository.get, sender.get))
      else None
   }
}


case class DeploymentStatusEvent(
                                deployment: GH3Deployment,
                                deployment_status: GH3DeploymentStatus,
                                repository: GH3Repository,
                                sender: GH3Sender
                                ) extends GH3Event

object DeploymentStatusEvent
{
   def apply(json: JValue): Option[DeploymentStatusEvent] =
   {
      val deployment = GH3Deployment(json \ "deployment")
      val deployment_status = GH3DeploymentStatus(json \ "deployment_status")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(deployment, deployment_status, repository, sender)

      if(params.forall(_.isDefined))
         Some(new DeploymentStatusEvent(deployment.get, deployment_status.get, repository.get, sender.get))
      else None
   }
}

case class ForkEvent( forkee: GH3Forkee,
                      repository: GH3Repository,
                      sender: GH3Sender) extends GH3Event

object ForkEvent
{
   def apply(json: JValue): Option[ForkEvent] =
   {
      val forkee = GH3Forkee(json \ "forkee")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(forkee, repository, sender).forall(_.isDefined))
         Some(new ForkEvent(forkee.get, repository.get, sender.get))
      else None
   }
}

case class GollumEvent( pages: Seq[GH3Page],
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object GollumEvent
{
   def apply(json: JValue): Option[GollumEvent] =
   {
      val pages = (json \ "pages") match {
         case JArray(a) => a.map(x => GH3Page(x))
      }

      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(repository, sender).forall(_.isDefined))
         Some(new GollumEvent(pages.map(_.get), repository.get, sender.get))
      else
         None
   }
}

case class IssueCommentEvent(action: String,
                             issue: GH3Issue,
                             comment: GH3IssueComment,
                             repository: GH3Repository,
                             sender: GH3Sender
                            ) extends GH3Event

object IssueCommentEvent
{
   def apply(json: JValue): Option[IssueCommentEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val issue = GH3Issue(json \ "issue")
      val comment = GH3IssueComment(json \ "comment")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(action, issue, comment, repository, sender)

      if(params.forall(_.isDefined))
         Some(new IssueCommentEvent(action.get, issue.get, comment.get, repository.get, sender.get))
      else None
   }
}

case class IssuesEvent(
                        action: String,
                        issue: GH3Issue,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object IssuesEvent
{
   def apply(json: JValue): Option[IssuesEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val issue = GH3Issue(json \ "issue")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, issue, repository, sender).forall(_.isDefined))
         Some(new IssuesEvent(action.get, issue.get, repository.get, sender.get))
      else None
   }
}

case class MemberEvent(
                        action: String,
                        member: GH3Sender,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object MemberEvent
{
   def apply(json: JValue): Option[MemberEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val member = GH3Sender(json \ "member")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, member, repository, sender).forall(_.isDefined))
         Some(new MemberEvent(action.get, member.get, repository.get, sender.get))
      else None
   }
}

case class MembershipEvent(
                           action: String,
                           scope: String,
                           member: GH3Sender,
                           sender: GH3Sender,
                           team: GH3Team,
                           organization: GH3Organization
                          ) extends GH3Event

object MembershipEvent
{
   def apply(json: JValue): Option[MembershipEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val scope  = n2s("scope")
      val member = GH3Sender(json \ "member")
      val sender = GH3Sender(json \ "sender")
      val team   = GH3Team(json \ "team")
      val organization = GH3Organization(json \ "organization")

      if(Seq(action, scope, member, sender, team, organization).forall(_.isDefined))
         Some(new MembershipEvent(action.get, scope.get, member.get, sender.get, team.get, organization.get))
      else None
   }
}

case class PageBuildEvent(
                           id: Long,
                           build: GH3Build,
                           repository: GH3Repository,
                           sender: GH3Sender
                         ) extends GH3Event

object PageBuildEvent
{
   def apply(json: JValue): Option[PageBuildEvent] =
   {
      val n2s = node2String(json)(_)
      val n2l = node2Long(json)(_)

      val id = n2l("id")
      val build = GH3Build(json \ "build")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(id, build, repository, sender).forall(_.isDefined))
         Some(new PageBuildEvent(id.get, build.get, repository.get, sender.get))
      else None
   }
}

case class PublicEvent(
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

object PublicEvent
{
   def apply(json: JValue): Option[PublicEvent] =
   {
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(repository, sender).forall(_.isDefined))
         Some(new PublicEvent(repository.get, sender.get))
      else None
   }
}

case class PullRequestEvent(
                              action: String,
                              number: Long,
                              pull_request: GH3PullRequest,
                              repository: GH3Repository,
                              sender: GH3Sender
                           ) extends GH3Event

object PullRequestEvent
{
   def apply(json: JValue): Option[PullRequestEvent] =
   {
      val action = node2String(json)("action")
      val number = node2Long(json)("number")
      val pull_request = GH3PullRequest(json \ "pull_request")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, number, pull_request, repository, sender).forall(_.isDefined))
         Some(new PullRequestEvent(action.get, number.get, pull_request.get, repository.get, sender.get))
      else None
   }
}



case class PullRequestReviewCommentEvent(
                                          action: String,
                                          comment: GH3PullRequestComment,
                                          pull_request: GH3PullRequest,
                                          repository: GH3Repository,
                                          sender: GH3Sender
                                        ) extends GH3Event

case class PushEvent(
                          ref: String,
                          before: String,
                          after: String,
                          created: Boolean,
                          deleted: Boolean,
                          forced: Boolean,
                          base_ref: Option[String],
                          compare: String,
                          commits: Seq[GH3Commit],
                          head_commit: GH3Commit,
                          repository: GH3Repository,
                          pusher: GH3Owner,
                          sender: GH3Sender

                       ) extends GH3Event

case class ReleaseEvent(
                           action: String,
                           release: GH3Release,
                           repository: GH3Repository,
                           sender: GH3Sender
                       ) extends GH3Event

object ReleaseEvent
{
   def apply(json: JValue): Option[ReleaseEvent] =
   {
      val n2s = node2String(json)(_)

      val action = n2s("action")
      val release = GH3Release(json \ "release")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      if(Seq(action, release, repository, sender).forall(_.isDefined))
         Some(new ReleaseEvent(action.get, release.get, repository.get, sender.get))
      else None
   }
}

case class RepositoryEvent(
                           action: String,
                           repository: GH3Repository,
                           organization: GH3Organization,
                           sender: GH3Sender
                          ) extends GH3Event

case class WatchEvent(
                        action: String,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event