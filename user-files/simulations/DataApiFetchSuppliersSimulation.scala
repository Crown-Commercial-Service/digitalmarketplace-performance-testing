import io.gatling.core.Predef._
import utils.SimulationProperties._
import utils.DigitalMarketplaceHttpConf
import scenarios.DataApiScenarios.fetchSuppliers

class DataApiFetchSuppliersSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(
    fetchSuppliers.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
  )
}