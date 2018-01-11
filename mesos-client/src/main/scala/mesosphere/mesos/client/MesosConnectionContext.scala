package mesosphere.mesos.client

import java.net.URI

import mesosphere.mesos.conf.MesosConf
import org.apache.mesos.v1.mesos.FrameworkID

case class MesosConnectionContext(url: URI,
                                  streamId: Option[String],
                                  frameworkId: Option[FrameworkID]) {
  def host = url.getHost
  def port = url.getPort
}


object MesosConnectionContext {
  def apply(conf: MesosConf): MesosConnectionContext = MesosConnectionContext(
    new java.net.URI(s"http://${conf.mesosMaster()}"),
    None,
    None)
}