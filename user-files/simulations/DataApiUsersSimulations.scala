import io.gatling.core.Predef._
import scenarios.DataApiScenarios.loginUsers
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

class DataApiLoginUsersSimulation extends Simulation with DigitalMarketplaceHttpConf{
  setUp(loginUsers.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
}
