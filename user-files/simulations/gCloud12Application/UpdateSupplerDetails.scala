package gCloud12Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object UpdateSupplerDetails {

	val headers_0 = Map(
		"Origin" -> "http://localhost",
		"Upgrade-Insecure-Requests" -> "1",
		"X-CSRFToken" -> "${csrf}")

	val headers_1 = Map("Upgrade-Insecure-Requests" -> "1",
		"X-CSRFToken" -> "${csrf}")

	val headers_7 = Map("Accept" -> "*/*",
		"X-CSRFToken" -> "${csrf}")

	var sp = System.getProperty("scalePauses").toDouble

	val updateSupplierDetails = exec(http("register_interest_request_1")
			.post("/suppliers/frameworks/g-cloud-12")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_1")
			.get("/suppliers/details")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_2")
			.get("/suppliers/what-buyers-will-see/edit")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_3")
			.post("/suppliers/what-buyers-will-see/edit")
			.headers(headers_0)
			.formParam("contactName", "Load test")
			.formParam("email", "load@test.com")
			.formParam("phoneNumber", "1234567890")
			.formParam("description", "50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum "))
		.pause((sp*23).toInt)
		.exec(http("update_details_request_4")
			.get("/suppliers/registered-company-name/edit")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_6")
			.get("/suppliers/registered-address/edit")
			.headers(headers_1)
			.resources(http("update_details_request_7")
			.get("/suppliers/static/location-autocomplete-graph.json")
			.headers(headers_7)))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_8")
			.post("/suppliers/registered-address/edit")
			.headers(headers_0)
			.formParam("street", "The Load Building, Test Street")
			.formParam("city", "Testville")
			.formParam("postcode", "TE5 TER")
			.formParam("country", "territory:AQ"))
		.pause((sp*23).toInt)
		.exec(http("update_details_request_9")
			.get("/suppliers/registration-number/edit")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_11")
			.get("/suppliers/trading-status/edit")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_12")
			.post("/suppliers/trading-status/edit")
			.headers(headers_0)
			.formParam("trading_status", "limited company (LTD)"))
		.pause((sp*23).toInt)
		.exec(http("update_details_request_13")
			.get("/suppliers/organisation-size/edit")
			.headers(headers_1))
		.pause((sp*11).toInt)
		.exec(http("update_details_request_14")
			.post("/suppliers/organisation-size/edit")
			.headers(headers_0)
			.formParam("organisation_size", "medium"))
		.pause((sp*23).toInt)
		.exec(http("update_details_request_17")
			.post("/suppliers/details")
			.headers(headers_0))
		.pause((sp*23).toInt)
}
