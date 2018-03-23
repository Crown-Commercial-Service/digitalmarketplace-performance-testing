package gCloud10Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Login extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

	val headers_0 = Map(
		"Origin" -> "http://localhost",
		"Upgrade-Insecure-Requests" -> "1")

	val user_feeder = csv("users.csv").circular

	val scn = scenario("Login")
		.exec(http("request_0")
			.post("/user/login")
			.headers(headers_0)
			.formParam("csrf_token", "None")
			.formParam("email_address", "${emailAddress}")
			.formParam("password", "${password}"))
			.pause(1)

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
