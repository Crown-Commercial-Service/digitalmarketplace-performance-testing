import io.gatling.core.Predef._
import scenarios.DataApiScenarios._
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

class DataApiFetchServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(fetchServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}

class DataApiFetchServicesBySupplierSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(fetchServicesBySupplier.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}

class DataApiImportServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(importServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}

class DataApiUpdateAndFetchServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(
    updateServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf),
    fetchServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
  )
}

class DataApiUpdateServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(updateServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}

