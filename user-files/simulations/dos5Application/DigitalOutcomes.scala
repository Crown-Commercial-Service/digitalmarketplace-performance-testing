package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object DigitalOutcomes {
	val headers_2 = Map("Origin" -> "https://www.staging.marketplace.team")

	val headers_4 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------21460247092912243081601027264",
		"X-CSRFToken" -> "${csrf}")

	val headers_6 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------29468737022914270163668790171",
		"X-CSRFToken" -> "${csrf}")

	val headers_8 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------124087004515881004831524459239",
		"X-CSRFToken" -> "${csrf}")

	val headers_10 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------22449315698092862891631850767",
		"X-CSRFToken" -> "${csrf}")

	val headers_12 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------7420412422496790582942074218",
		"X-CSRFToken" -> "${csrf}")

	val headers_14 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------35247991863788267533738351212",
		"X-CSRFToken" -> "${csrf}")

	val headers_16 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------297176180637035423944177529700",
		"X-CSRFToken" -> "${csrf}")

	val headers_18 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------120071512631045619922299303785",
		"X-CSRFToken" -> "${csrf}")

	val headers_20 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------321113156126367251871404808924",
		"X-CSRFToken" -> "${csrf}")

	val headers_22 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------19571195072417620537414011955",
		"X-CSRFToken" -> "${csrf}")



	val digital_outcomes = exec(http("digital_outcomes_request_0")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions"))
		.pause(1)
		.exec(http("digital_outcomes_request_1")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes"))
		.pause(1)
		.exec(http("digital_outcomes_request_2")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/previous-services")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}")
			.formParam("copy_service", "False")
			.check(currentLocationRegex(".*/(\\d*)").saveAs("service_id")))
	.pause(1)
		.exec(http("digital_outcomes_request_3")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/service-essentials?hidden_text=Service+essentials"))
		.pause(1)
		.exec(http("digital_outcomes_request_4")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/service-essentials")
			.headers(headers_4)
			.body(RawFileBody("dos5Application/digital_outcomes/0004_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_5")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/performance-analysis-and-data"))
		.pause(1)
		.exec(http("digital_outcomes_request_6")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/performance-analysis-and-data")
			.headers(headers_6)
			.body(RawFileBody("dos5Application/digital_outcomes/0006_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_7")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/security"))
		.pause(1)
		.exec(http("digital_outcomes_request_8")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/security")
			.headers(headers_8)
			.body(RawFileBody("dos5Application/digital_outcomes/0008_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_9")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/service-delivery"))
		.pause(1)
		.exec(http("digital_outcomes_request_10")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/service-delivery")
			.headers(headers_10)
			.body(RawFileBody("dos5Application/digital_outcomes/0010_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_11")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/software-development"))
		.pause(1)
		.exec(http("digital_outcomes_request_12")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/software-development")
			.headers(headers_12)
			.body(RawFileBody("dos5Application/digital_outcomes/0012_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_13")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/support-and-operations"))
		.pause(1)
		.exec(http("digital_outcomes_request_14")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/support-and-operations")
			.headers(headers_14)
			.body(RawFileBody("dos5Application/digital_outcomes/0014_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_15")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/testing-and-auditing"))
		.pause(1)
		.exec(http("digital_outcomes_request_16")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/testing-and-auditing")
			.headers(headers_16)
			.body(RawFileBody("dos5Application/digital_outcomes/0016_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_17")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/user-experience-and-design"))
		.pause(1)
		.exec(http("digital_outcomes_request_18")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/user-experience-and-design")
			.headers(headers_18)
			.body(RawFileBody("dos5Application/digital_outcomes/0018_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_19")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/user-research"))
		.pause(1)
		.exec(http("digital_outcomes_request_20")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/team-capabilities/user-research")
			.headers(headers_20)
			.body(RawFileBody("dos5Application/digital_outcomes/0020_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_21")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/outcomes-locations?hidden_text=Outcomes+locations"))
		.pause(1)
		.exec(http("digital_outcomes_request_22")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/edit/outcomes-locations")
			.headers(headers_22)
			.body(RawFileBody("dos5Application/digital_outcomes/0022_request.dat")))
		.pause(1)
		.exec(http("digital_outcomes_request_23")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-outcomes/${service_id}/complete")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}"))
}
