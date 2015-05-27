import utils.{SimulationProperties, DigitalMarketplaceHttpConf}
import SimulationProperties._
import io.gatling.core.Predef._
import scenarios.SearchScenarios.buyerAppSearch

class BuyerAppSearchSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(buyerAppSearch.inject(atOnceUsers(numberOfUsers)).protocols(wwwHttpConf))
}
