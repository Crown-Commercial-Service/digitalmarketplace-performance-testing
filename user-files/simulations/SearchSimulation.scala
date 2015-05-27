import CustomFeeders.searchTerms
import SimulationProperties._
import ScenarioHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class SearchSimulation extends Simulation with DigitalMarketplaceHttpConf {

  val search = scenario("Search")
    .keepRepeating {
    feed(searchTerms)
      .exec(http("Search")
        .get("/g-cloud/search?q=${search_term}")
        .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }
  setUp(search.inject(atOnceUsers(numberOfUsers)).protocols(wwwHttpConf))
}
