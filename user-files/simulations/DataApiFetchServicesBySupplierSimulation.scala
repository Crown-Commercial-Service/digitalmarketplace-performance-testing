import io.gatling.core.Predef._
import scenarios.DataApiScenarios.fetchServicesBySupplier
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

class DataApiFetchServicesBySupplierSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(fetchServicesBySupplier.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
