import io.gatling.core.Predef._
import scenarios.DataApiScenarios.importServices
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

class DataApiImportServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(importServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
