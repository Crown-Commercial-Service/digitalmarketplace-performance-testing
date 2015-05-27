import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SearchSimulation extends Simulation {

  val search = scenario("Search")
    .exec(http("Search")
      .get("/search?q=stuff")
      .check(status.is(200))
    )

  setUp(search.inject(atOnceUsers(1000)).protocols(httpConf))
}
