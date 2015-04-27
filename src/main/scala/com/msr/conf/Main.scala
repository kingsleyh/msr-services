package com.msr.conf

import akka.actor.ActorSystem

object Main extends App {

  implicit val system = ActorSystem("msr-service")
  system.actorOf(MsrMainConfig.props, MsrMainConfig.name)

}
