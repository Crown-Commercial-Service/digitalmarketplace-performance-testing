import utils.{SimulationProperties, DigitalMarketplaceHttpConf}
import SimulationProperties._
import io.gatling.core.Predef._
import scenarios.BuyerAppScenarios.buyerAppServicePage


class BuyerAppServicePageSimulation extends Simulation with DigitalMarketplaceHttpConf {
  setUp(buyerAppServicePage.inject(atOnceUsers(numberOfUsers)).protocols(wwwHttpConf))
}
