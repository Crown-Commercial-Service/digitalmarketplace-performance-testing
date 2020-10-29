package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object UserResearchParticipants {
	val headers_2 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------41531104481094415240155537240",
		"X-CSRFToken" -> "${csrf}")

	val headers_4 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------351850086735558536793488413169",
		"X-CSRFToken" -> "${csrf}")

	val headers_6 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------20079302206561911143475410322",
		"X-CSRFToken" -> "${csrf}")

	val headers_7 = Map("Origin" -> "https://www.staging.marketplace.team")

	val user_research_participants = exec(http("user_research_participants_request_0")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants")
			.check(currentLocationRegex(".*/(\\d*)").saveAs("service_id")))
		.pause(1)
		.exec(http("user_research_participants_request_1")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/user-research-participants-essentials?hidden_text=User+research+participants+essentials"))
		.pause(1)
		.exec(http("user_research_participants_request_2")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/user-research-participants-essentials")
			.headers(headers_2)
			.body(RawFileBody("dos5Application/userresearchparticipants/0002_request.dat")))
		.pause(1)
		.exec(http("user_research_participants_request_3")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/recruitment-approach?hidden_text=Recruitment+approach"))
		.pause(1)
		.exec(http("user_research_participants_request_4")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/recruitment-approach")
			.headers(headers_4)
			.body(RawFileBody("dos5Application/userresearchparticipants/0004_request.dat")))
		.pause(1)
		.exec(http("user_research_participants_request_5")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/location?hidden_text=Location"))
		.pause(1)
		.exec(http("user_research_participants_request_6")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/edit/location")
			.headers(headers_6)
			.body(RawFileBody("dos5Application/userresearchparticipants/0006_request.dat")))
		.pause(1)
		.exec(http("user_research_participants_request_7")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-participants/${service_id}/complete")
			.headers(headers_7)
			.formParam("csrf_token", "${csrf}"))
}
