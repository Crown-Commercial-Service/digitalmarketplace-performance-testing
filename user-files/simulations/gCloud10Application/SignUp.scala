package gCloud10Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object SignUp {

  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val headers_3 = Map(
    "Content-Type" -> "multipart/form-data; boundary=--WebKitFormBoundaryH2hTfwjGBpETaysO",
    "Origin" -> "http://localhost",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_99 = Map(
    "Origin" -> "http://localhost",
    "Upgrade-Insecure-Requests" -> "1")

  val sign_up = exec(http("hosting_service_request_0")
      .get("/suppliers/supply")
      .headers(headers_0))
    .pause(11)
    .exec(http("hosting_service_request_1")
        .get("/suppliers/create/start")
        .headers(headers_0))
    .pause(11)
    .exec(http("hosting_service_request_2")
        .get("/suppliers/create/duns-number")
        .headers(headers_0))
    .pause(11)
    .exec(http("hosting_service_request_3")
        .post("/suppliers/create/duns-number")
        .headers(headers_3)
        .formParam("input-duns_number", "000333444"))
    .pause(11)
    .exec(http("Contact details")
        .post("suppliers/create/company-details")
        .formParam("input-company_name", "Gatling Co")
        .formParam("input-contact_name", "Gatling Contact")
        .formParam("input-email_address", "test@example.com")
        .formParam("input-phone_number", "07777777777")
        .headers(headers_3))
    .pause(11)
    .exec(http("Create login")
        .post("suppliers/create/account")
        .formParam("input-email_address", "company@example.com")
        .headers(headers_3))
    .pause(11)
    .exec(http("Check info")
      .post("suppliers/create/company-summary")
      .headers(headers_3)
    )
    .pause(11)

  val applyAsSupplier = exec(
    exitBlockOnFail {
      pause(11)
        .exec(sign_up)
    }
  )
}