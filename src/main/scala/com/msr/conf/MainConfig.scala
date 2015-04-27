package com.msr.conf

import akka.actor.SupervisorStrategy.{Stop, Restart}
import akka.actor._
import akka.io.IO
import akka.util.Timeout
import spray.can.Http

// have a look at https://github.com/stig/spray-example

object MsrMainConfig {
  def props :Props = Props[ProductionMainConfig]
  def name = "msr-main-config"
}


class ProductionMainConfig  extends MsrMainConfig with MainConfig {
  private def configuration = context.system.settings.config
  def interface = configuration.getString("msr.service.interface")
  def port = configuration.getInt("msr.service.port")
  implicit def askTimeout = Timeout(configuration.getMilliseconds("msr.service.ask-timeout"))

  def createModel = context.actorOf(ModelActor.props, ModelActor.name)
  def createService(model : ActorRef) = context.actorOf(ServiceActor.props(model), ServiceActor.name)
}

trait MainConfig {
  def createModel: ActorRef
  def createService(model: ActorRef): ActorRef
  def interface: String
  def port: Int
}

class MsrMainConfig extends Actor with ActorLogging {
  this : MainConfig =>

  val model = createModel
  context watch model

  val service = createService(model)
  context watch service

  import context._
  IO(Http) ! Http.Bind(service, interface, port)

  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
    case _ if model == sender => Stop
    case _ if service == sender => Restart
  }

  def receive = {
    case Http.CommandFailed(_) => context stop self
    case Terminated(`model`) => context stop self
    case _ =>
  }
}

