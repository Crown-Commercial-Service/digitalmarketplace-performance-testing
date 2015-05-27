import io.gatling.core.Predef._
import utils.SimulationProperties._
import utils.DigitalMarketplaceHttpConf
import scenarios.DataApiScenarios.fetchServices

class DataApiFetchServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(fetchServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
