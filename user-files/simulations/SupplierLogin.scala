import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object SupplierLogin {

	val headers_0 = Map(
		"Origin" -> "http://localhost",
		"Upgrade-Insecure-Requests" -> "1")

	val user_feeder = csv("supplier_logins.csv").circular

	val login = feed(user_feeder)
		.exec(http("login_request_0")
			.get("/user/login")
            .check(css("input[name=csrf_token]", "value").saveAs("csrf"))
			.headers(headers_0))
		.exec(http("login_request_1")
			.post("/user/login")
			.headers(headers_0)
			.formParam("csrf_token", "${csrf}")
			.formParam("email_address", "${emailAddress}")
			.formParam("password", "${password}"))
		.pause(1)
}
