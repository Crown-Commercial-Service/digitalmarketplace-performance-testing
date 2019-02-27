package gCloud10Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object Login {

	val headers_0 = Map(
		"Origin" -> "http://localhost",
		"Upgrade-Insecure-Requests" -> "1")

	val user_feeder = csv("g_10_supplier_logins.csv").circular

	val login = feed(user_feeder)
		.exec(http("login_request_0")
			.post("/user/login")
			.headers(headers_0)
			.formParam("csrf_token", "None")
			.formParam("email_address", "${emailAddress}")
			.formParam("password", "${password}"))
		.pause(1)
}
