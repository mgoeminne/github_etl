package gh3

import net.liftweb.json.JsonAST.{JString, JValue}

sealed class GH3Event


case class CommitCommentEvent(
                             action: String,
                             comment: GH3Comment,
                             repository: GH3Repository,
                             sender: GH3Sender
                             ) extends GH3Event

object CommitCommentEvent{
   def apply(json: JValue): Option[CommitCommentEvent] =
   {
      val action = node2String(json \ "action")
      val comment = GH3Comment(json \ "comment")
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
      val ref = node2String(json \ "ref")
      val ref_type = node2String(json \ "ref_type")
      val master_branch = node2String(json \ "master_branch")
      val description = node2String(json \ "description")
      val pusher_type = node2String(json \ "pusher_type")
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
      val ref = node2String(json \ "ref")
      val ref_type = node2String(json \ "ref_type")
      val pusher_type = node2String(json \ "pusher_type")
      val repository = GH3Repository(json \ "repository")
      val sender = GH3Sender(json \ "sender")

      val params = Seq(ref, ref_type, pusher_type, repository, sender)

      if(params.forall(_.isDefined))
         Some(new DeleteEvent(ref.get, ref_type.get, pusher_type.get, repository.get, sender.get))
      else
         None
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

case class IssueCommentEvent( action: String,
                              issue: GH3Issue,
                              comment: GH3Comment,
                              repository: GH3Repository,
                              sender: GH3Sender
                            ) extends GH3Event

case class IssuesEvent(
                        action: String,
                        issue: GH3Issue,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

case class MemberEvent(
                        action: String,
                        member: GH3Sender,
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

case class MembershipEvent(
                           action: String,
                           scope: String,
                           member: GH3Sender,
                           sender: GH3Sender,
                           team: GH3Team,
                           organization: GH3Organization

                          ) extends GH3Event

case class PageBuildEvent(
                           id: Long,
                           build: GH3Build,
                           repository: GH3Repository,
                           sender: GH3Sender
                         ) extends GH3Event

case class PublicEvent(
                        repository: GH3Repository,
                        sender: GH3Sender
                      ) extends GH3Event

case class PullRequestEvent(
                              action: String,
                              number: Long,
                              pull_request: GH3PullRequest,
                              repository: GH3Repository,
                              sender: GH3Sender
                           ) extends GH3Event




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