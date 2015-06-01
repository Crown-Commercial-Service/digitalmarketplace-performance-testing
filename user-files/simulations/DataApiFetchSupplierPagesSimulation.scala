import io.gatling.core.Predef._
import utils.SimulationProperties._
import utils.DigitalMarketplaceHttpConf
import scenarios.DataApiScenarios.fetchSupplierPages

class DataApiFetchSupplierPagesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(
    fetchSupplierPages.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
  )
}
