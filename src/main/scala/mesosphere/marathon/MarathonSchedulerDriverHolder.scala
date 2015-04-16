package mesosphere.marathon

import org.apache.mesos.SchedulerDriver

/**
  * Holds the current instances of the driver and the scheduler.
  *
  * (Should probably be refactored)
  */
class MarathonSchedulerDriverHolder {
  @volatile
  var driver: Option[SchedulerDriver] = None
}