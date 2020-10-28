package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object ConfirmDetails {
	val headers_4 = Map("Origin" -> "https://www.preview.marketplace.team")

	val confirm_details = exec(http("Register framework interest")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5")
			.headers(headers_4)
			.formParam("csrf_token", "${csrf}"))
		.pause(1)
		.exec(http("View supplier details")
			.get("/suppliers/details"))
		.pause(1)
		.exec(http("Confirm supplier details")
			.post("/suppliers/details")
			.headers(headers_4)
			.formParam("csrf_token", "${csrf}"))
}