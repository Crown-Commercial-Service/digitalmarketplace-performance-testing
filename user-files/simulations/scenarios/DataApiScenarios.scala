package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.CustomFeeders.{randomServiceId, supplierIds, randomPage, serviceIds}
import utils.ScenarioHelpers._
import utils.SimulationProperties._

import scala.concurrent.duration._

object DataApiScenarios {

  val fetchServices = scenario("FetchServices")
    .keepRepeating {
    feed(randomPage)
      .exec(http("FetchServices")
      .get("/services?page=${random_page}")
      .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }

  val fetchServicesBySupplier = scenario("FetchServicesBySupplier")
    .keepRepeating {
    feed(supplierIds)
      .exec(http("FetchServicesBySupplier")
      .get("/services?supplier_id=${supplier_id}")
      .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }

  private val headersMap = Map("Content-type" -> "application/json")

  val importServices = scenario("ImportServices")
    .keepRepeating {
    feed(randomServiceId)
      .feed(supplierIds)
      .exec(
        http("ImportServices")
          .put("/services/${random_number}")
          .body(ELFileBody("service.json"))
          .headers(headersMap)
          .check(status.is(201))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }

  val updateServices = scenario("UpdateServices")
    .keepRepeating {
    feed(serviceIds)
      .exec(
        http("UpdateServices")
          .post("/services/${service_id}")
          .body(ELFileBody("service_update.json"))
          .headers(headersMap)
          .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }

}
