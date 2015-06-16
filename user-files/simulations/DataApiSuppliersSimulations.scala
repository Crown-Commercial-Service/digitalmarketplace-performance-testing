import io.gatling.core.Predef._
import utils.SimulationProperties._
import utils.DigitalMarketplaceHttpConf
import scenarios.DataApiScenarios._

class DataApiFetchSupplierPagesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(
    fetchSupplierPages.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
  )
}

class DataApiFetchSuppliersSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(
    fetchSuppliers.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
  )
}

class DataApiImportSuppliersSimulation extends Simulation with DigitalMarketplaceHttpConf{
  setUp(importSuppliers.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
