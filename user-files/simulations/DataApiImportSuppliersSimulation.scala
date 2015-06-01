import io.gatling.core.Predef._
import utils.SimulationProperties._
import utils.DigitalMarketplaceHttpConf
import scenarios.DataApiScenarios.importSuppliers

class DataApiImportSuppliersSimulation extends Simulation with DigitalMarketplaceHttpConf{
  setUp(importSuppliers.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
