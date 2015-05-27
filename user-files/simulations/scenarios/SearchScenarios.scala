package scenarios

import utils.{SimulationProperties, ScenarioHelpers, DigitalMarketplaceHttpConf, CustomFeeders}
import CustomFeeders.searchTerms
import SimulationProperties._
import ScenarioHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object SearchScenarios {
  val buyerAppSearch = scenario("Buyer App Search")
    .keepRepeating {
    feed(searchTerms)
      .exec(http("Buyer APp Search")
      .get("/g-cloud/search?q=${search_term}")
      .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }
}
