package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object DigitalSpecialists {
	val headers_1 = Map("Origin" -> "https://www.staging.marketplace.team")

	val headers_3 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------42139310339840454352608837687",
		"X-CSRFToken" -> "${csrf}")

	val headers_5 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------22352328897297489051699966978",
		"X-CSRFToken" -> "${csrf}")

	val headers_7 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------180112745635736437083702012375",
		"X-CSRFToken" -> "${csrf}")

	val headers_9 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------3796811107861587083318579163",
		"X-CSRFToken" -> "${csrf}")

	val headers_11 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------157643059741494264751867709940",
		"X-CSRFToken" -> "${csrf}")

	val headers_13 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------36211020953439029951165717325",
		"X-CSRFToken" -> "${csrf}")

	val headers_15 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------38463631519718952651754266027",
		"X-CSRFToken" -> "${csrf}")

	val headers_17 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------302709141110700577211877807176",
		"X-CSRFToken" -> "${csrf}")

	val headers_19 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------260808757614221440392940241424",
		"X-CSRFToken" -> "${csrf}")

	val digital_specialists = exec(http("digital_specialists_request_0")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists"))
		.pause(1)
		.exec(http("digital_specialists_request_1")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/previous-services")
			.headers(headers_1)
			.formParam("csrf_token", "${csrf}")
			.formParam("copy_service", "False")
			.check(currentLocationRegex(".*/(\\d*)").saveAs("service_id")))
		.pause(1)
		.exec(http("digital_specialists_request_2")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/service-essentials?hidden_text=Service+essentials"))
		.pause(1)
		.exec(http("digital_specialists_request_3")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/service-essentials")
			.headers(headers_3)
			.body(RawFileBody("dos5Application/digitalspecialists/0003_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_4")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/agile-coach"))
		.pause(1)
		.exec(http("digital_specialists_request_5")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/agile-coach")
			.headers(headers_5)
			.body(RawFileBody("dos5Application/digitalspecialists/0005_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_6")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/data-architect"))
		.pause(1)
		.exec(http("digital_specialists_request_7")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/data-architect")
			.headers(headers_7)
			.body(RawFileBody("dos5Application/digitalspecialists/0007_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_8")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/developer"))
		.pause(1)
		.exec(http("digital_specialists_request_9")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/developer")
			.headers(headers_9)
			.body(RawFileBody("dos5Application/digitalspecialists/0009_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_10")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/technical-architect"))
		.pause(1)
		.exec(http("digital_specialists_request_11")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/technical-architect")
			.headers(headers_11)
			.body(RawFileBody("dos5Application/digitalspecialists/0011_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_12")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/web-operations-engineer"))
		.pause(1)
		.exec(http("digital_specialists_request_13")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/web-operations-engineer")
			.headers(headers_13)
			.body(RawFileBody("dos5Application/digitalspecialists/0013_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_14")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/programme-manager"))
		.pause(1)
		.exec(http("digital_specialists_request_15")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/programme-manager")
			.headers(headers_15)
			.body(RawFileBody("dos5Application/digitalspecialists/0015_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_16")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/communications-manager"))
		.pause(1)
		.exec(http("digital_specialists_request_17")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/communications-manager")
			.headers(headers_17)
			.body(RawFileBody("dos5Application/digitalspecialists/0017_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_18")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/content-designer"))
		.pause(1)
		.exec(http("digital_specialists_request_19")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/edit/individual-specialist-roles/content-designer")
			.headers(headers_19)
			.body(RawFileBody("dos5Application/digitalspecialists/0019_request.dat")))
		.pause(1)
		.exec(http("digital_specialists_request_20")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/digital-specialists/${service_id}/complete")
			.headers(headers_1)
			.formParam("csrf_token", "${csrf}"))
}
