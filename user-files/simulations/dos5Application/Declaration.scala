package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object Declaration {

	val headers_2 = Map("Origin" -> "https://www.preview.marketplace.team")

	val headers_10 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------5592021863602026712919368383",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_11 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------296055603715196076111240586267",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_12 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------3047941344499090043205192015",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_13 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------14314609284858212991005344918",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_14 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------49970962817506559082037960245",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_15 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------34932573918597187631988456033",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_16 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------29018113617565363464061481982",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_17 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------28257485576602910553370608117",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_18 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------4272951164195653437276699264",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_19 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------30195968756473493152529848835",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")



	val declaration = exec(http("request_6")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/start"))
		.pause(1)
		.exec(http("request_7")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/reuse"))
		.pause(1)
		.exec(http("request_9")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/how-you-apply"))
		.pause(1)
		.exec(http("request_10")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/how-you-apply")
			.headers(headers_10)
			.body(RawFileBody("dos5Application/declaration/0010_request.dat")))
		.pause(1)
		.exec(http("request_11")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/providing-suitable-services")
			.headers(headers_11)
			.body(RawFileBody("dos5Application/declaration/0011_request.dat")))
		.pause(1)
		.exec(http("request_12")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/what-it-means-to-be-on-digital-outcomes-and-specialists-5")
			.headers(headers_12)
			.body(RawFileBody("dos5Application/declaration/0012_request.dat")))
		.pause(1)
		.exec(http("request_13")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/grounds-for-mandatory-exclusion")
			.headers(headers_13)
			.body(RawFileBody("dos5Application/declaration/0013_request.dat")))
		.pause(1)
		.exec(http("request_14")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/grounds-for-discretionary-exclusion")
			.headers(headers_14)
			.body(RawFileBody("dos5Application/declaration/0014_request.dat")))
		.pause(1)
		.exec(http("request_15")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/working-with-government")
			.headers(headers_15)
			.body(RawFileBody("dos5Application/declaration/0015_request.dat")))
		.pause(1)
		.exec(http("request_16")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/application-accuracy")
			.headers(headers_16)
			.body(RawFileBody("dos5Application/declaration/0016_request.dat")))
		.pause(1)
		.exec(http("request_17")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/how-youll-deliver-your-services")
			.headers(headers_17)
			.body(RawFileBody("dos5Application/declaration/0017_request.dat")))
		.pause(1)
		.exec(http("request_18")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/modern-slavery")
			.headers(headers_18)
			.body(RawFileBody("dos5Application/declaration/0018_request.dat")))
		.pause(1)
		.exec(http("request_19")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration/edit/contact-details")
			.headers(headers_19)
			.body(RawFileBody("dos5Application/declaration/0019_request.dat")))
		.pause(1)
		.exec(http("request_20")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/declaration")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}"))

}