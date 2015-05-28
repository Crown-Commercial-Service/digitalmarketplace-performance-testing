import io.gatling.core.Predef._
import scenarios.DataApiScenarios.updateServices
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

class DataApiUpdateServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(updateServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
