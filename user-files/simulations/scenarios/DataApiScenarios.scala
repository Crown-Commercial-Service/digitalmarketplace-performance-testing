package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.CustomFeeders.searchTerms
import utils.ScenarioHelpers._
import utils.SimulationProperties._

import scala.concurrent.duration._

object DataApiScenarios {
  val fetchServices = scenario("FetchServices")
    .keepRepeating {
    feed(searchTerms)
      .exec(http("FetchServices")
      .get("/services")
      .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }
}
