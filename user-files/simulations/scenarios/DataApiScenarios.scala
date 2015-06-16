package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.CustomFeeders.{randomServiceId, randomServicePage, serviceIds, randomSupplierId, randomSupplierPage, supplierIds}
import utils.ScenarioHelpers._
import utils.SimulationProperties._

import scala.concurrent.duration._

object DataApiScenarios {

  val fetchServices = scenario("FetchServices")
    .keepRepeating {
    feed(randomServicePage)
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

  private val supplierPagesFeed = feed(randomSupplierPage)
    .exec(
      http("Fetch supplier page")
        .get("/suppliers?page=${random_page}")
        .check(status.is(200))
        .check(jsonPath("$.suppliers[*].links.self").findAll.saveAs("supplierUrls"))
    )
    .pause(minIdleTime milliseconds, maxIdleTime milliseconds)

  val fetchSuppliers = scenario("Fetch suppliers")
    .keepRepeating {
    supplierPagesFeed
      .foreach("${supplierUrls}", "supplierUrl") {
      exec(
        http("Fetch supplier")
          .get("${supplierUrl}")
          .check(status.is(200))
      )
    }
  }

  val fetchSupplierPages = scenario("Fetch supplier pages")
    .keepRepeating { supplierPagesFeed }

  val importSuppliers = scenario("Import suppliers")
    .keepRepeating {
    feed(randomSupplierId)
      .exec(
        http("Import service")
          .put("/suppliers/${random_number}")
          .body(ELFileBody("supplier.json"))
          .headers(headersMap)
          .check(status.is(201))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }

  val loginUsers = scenario("Login users")
    .keepRepeating {
    feed(Iterator.continually(Map("supplierEmailAddress" -> s"${supplierEmailAddress}", "supplierPassword" -> s"${supplierPassword}")))
      .exec(
        http("Login user")
          .post("/users/auth")
          .body(ELFileBody("supplier-user-login.json"))
          .headers(headersMap)
          .check(status.is(200))
      ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
  }
}
