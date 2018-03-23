package gCloud10Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class UpdateSupplerDetails extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

	val headers_1 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_7 = Map("Accept" -> "*/*")

	val scn = scenario("UpdateSupplerDetails")
		.exec(http("request_1")
			.get("/suppliers/details")
			.headers(headers_1))
		.pause(3)
		.exec(http("request_2")
			.get("/suppliers/what-buyers-will-see/edit")
			.headers(headers_1))
		.pause(22)
		.exec(http("request_3")
			.post("/suppliers/what-buyers-will-see/edit")
			.headers(headers_0)
			.formParam("contactName", "Load test")
			.formParam("email", "load@test.com")
			.formParam("phoneNumber", "1234567890")
			.formParam("description", "50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum 50 words maximum "))
		.pause(2)
		.exec(http("request_4")
			.get("/suppliers/registered-company-name/edit")
			.headers(headers_1))
		.pause(6)
		.exec(http("request_5")
			.post("/suppliers/registered-company-name/edit")
			.headers(headers_0)
			.formParam("registered_company_name", "Load Test Ltd."))
		.pause(1)
		.exec(http("request_6")
			.get("/suppliers/registered-address/edit")
			.headers(headers_1)
			.resources(http("request_7")
			.get("/suppliers/static/location-autocomplete-graph.json")
			.headers(headers_7)))
		.pause(27)
		.exec(http("request_8")
			.post("/suppliers/registered-address/edit")
			.headers(headers_0)
			.formParam("address1", "The Load Building, Test Street")
			.formParam("city", "Testville")
			.formParam("postcode", "TE5 TER")
			.formParam("registrationCountry", "territory:AQ"))
		.pause(2)
		.exec(http("request_9")
			.get("/suppliers/registration-number/edit")
			.headers(headers_1))
		.pause(3)
		.exec(http("request_10")
			.post("/suppliers/registration-number/edit")
			.headers(headers_0)
			.formParam("has_companies_house_number", "Yes")
			.formParam("companies_house_number", "12345678")
			.formParam("other_company_registration_number", ""))
		.pause(2)
		.exec(http("request_11")
			.get("/suppliers/trading-status/edit")
			.headers(headers_1))
		.pause(1)
		.exec(http("request_12")
			.post("/suppliers/trading-status/edit")
			.headers(headers_0)
			.formParam("trading_status", "limited company (LTD)"))
		.pause(1)
		.exec(http("request_13")
			.get("/suppliers/organisation-size/edit")
			.headers(headers_1))
		.pause(1)
		.exec(http("request_14")
			.post("/suppliers/organisation-size/edit")
			.headers(headers_0)
			.formParam("organisation_size", "medium"))
		.pause(1)
		.exec(http("request_15")
			.get("/suppliers/vat-number/edit")
			.headers(headers_1))
		.pause(3)
		.exec(http("request_16")
			.post("/suppliers/vat-number/edit")
			.headers(headers_0)
			.formParam("vat_registered", "Yes")
			.formParam("vat_number", "123456789"))
		.pause(3)
		.exec(http("request_17")
			.post("/suppliers/details")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
