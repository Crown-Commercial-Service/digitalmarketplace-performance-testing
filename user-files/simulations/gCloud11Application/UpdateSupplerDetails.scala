package gCloud11Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object UpdateSupplerDetails {

	val headers_0 = Map(
		"Origin" -> "http://localhost",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_7 = Map("Accept" -> "*/*")

	val updateSupplierDetails = exec(http("update_details_request_1")
			.get("/suppliers/details")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_2")
			.get("/suppliers/what-buyers-will-see/edit")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_3")
			.post("/suppliers/what-buyers-will-see/edit")
			.headers(headers_0)
			.formParam("contactName", "Load test")
			.formParam("email", "load@test.com")
			.formParam("phoneNumber", "1234567890")
			.formParam("description", "50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum "))
		.pause(23)
		.exec(http("update_details_request_4")
			.get("/suppliers/registered-company-name/edit")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_6")
			.get("/suppliers/registered-address/edit")
			.headers(headers_1)
			.resources(http("update_details_request_7")
			.get("/suppliers/static/location-autocomplete-graph.json")
			.headers(headers_7)))
		.pause(11)
		.exec(http("update_details_request_8")
			.post("/suppliers/registered-address/edit")
			.headers(headers_0)
			.formParam("street", "The Load Building, Test Street")
			.formParam("city", "Testville")
			.formParam("postcode", "TE5 TER")
			.formParam("country", "territory:AQ"))
		.pause(23)
		.exec(http("update_details_request_9")
			.get("/suppliers/registration-number/edit")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_11")
			.get("/suppliers/trading-status/edit")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_12")
			.post("/suppliers/trading-status/edit")
			.headers(headers_0)
			.formParam("trading_status", "limited company (LTD)"))
		.pause(23)
		.exec(http("update_details_request_13")
			.get("/suppliers/organisation-size/edit")
			.headers(headers_1))
		.pause(11)
		.exec(http("update_details_request_14")
			.post("/suppliers/organisation-size/edit")
			.headers(headers_0)
			.formParam("organisation_size", "medium"))
		.pause(23)
		.exec(http("update_details_request_17")
			.post("/suppliers/details")
			.headers(headers_0))
		.pause(23)
}
