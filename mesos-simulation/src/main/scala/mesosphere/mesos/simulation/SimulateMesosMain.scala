package mesosphere.mesos.simulation

import com.google.inject.util.Modules
import com.google.inject.{ AbstractModule, Inject, Module, Provides }
import mesosphere.marathon._
import org.apache.mesos.SchedulerDriver

/**
  * Start marathon with a simulated mesos driver.
  */
object SimulateMesosMain extends DefaultMain {
  private[this] def simulatedDriverModule: Module = {
    new AbstractModule {
      override def configure(): Unit = {}

      @Provides
      @Inject
      def provideSchedulerDriver(holder: MarathonSchedulerDriverHolder,
                                 newScheduler: MarathonScheduler): SchedulerDriver = {
        val driver = SimulatedDriverWiring.createDriver(newScheduler)
        holder.driver = Some(driver)
        driver
      }
    }
  }

  override def modules(): Seq[Module] = {
    Seq(Modules.`override`(super.modules(): _*).`with`(simulatedDriverModule))
  }

  runDefault()
}
