package scenarios

import utils.{SimulationProperties, ScenarioHelpers, CustomFeeders}
import CustomFeeders.{searchTerms, serviceIds}
import SimulationProperties._
import ScenarioHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object BuyerAppScenarios {
  val buyerAppSearch = scenario("Buyer App Search")
    .keepRepeating {
      feed(searchTerms)
      .exec(
        http("Buyer App Search")
          .get("/g-cloud/search?q=${search_term}")
          .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
    }

  val buyerAppServicePage = scenario("Buyer App Service Page")
    .keepRepeating {
      feed(serviceIds)
        .exec(
          http("Buyer App Service Page")
            .get("/g-cloud/services/${service_id}")
            .check(status.is(200))
        ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
    }
}
