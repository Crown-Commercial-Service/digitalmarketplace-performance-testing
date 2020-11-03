package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object UserResearch {
	val headers_2 = Map("Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_7 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------6524107703910824523849338500",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_9 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------204663655638995021674052966857",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_11 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------338167890039750878941744962421",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_13 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------14201313838600358593549198586",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_15 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------360450282426473519091718533545",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_17 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------313878554642195587321937862205",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_19 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------125138263732913413623634586803",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_21 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------1602985585427104112953155029",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_23 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------389465930018851609742792349108",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")

	val headers_25 = Map(
		"Content-Type" -> "multipart/form-data; boundary=---------------------------215926236028865111991278550066",
		"Origin" -> "https://www.preview.marketplace.team",
		"X-CSRFToken" -> "${csrf}")



	val user_research = exec(http("user_research_request_3")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5"))
		.pause(1)
		.exec(http("user_research_request_4")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions"))
		.pause(1)
		.exec(http("user_research_request_5")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios"))
		.pause(1)
		.exec(http("user_research_request_6")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/create"))
		.pause(1)
		.exec(http("user_research_request_7")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/create")
			.headers(headers_7)
			.body(RawFileBody("dos5Application/user_research/0007_request.dat"))
			.check(currentLocationRegex(".*/(\\d*)").saveAs("service_id")))
		.pause(1)
		.exec(http("user_research_request_8")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/research-studio-address?hidden_text=Research+studio+address"))
		.pause(1)
		.exec(http("user_research_request_9")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/research-studio-address")
			.headers(headers_9)
			.body(RawFileBody("dos5Application/user_research/0009_request.dat")))
		.pause(1)
		.exec(http("user_research_request_10")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/transport?hidden_text=Transport"))
		.pause(1)
		.exec(http("user_research_request_11")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/transport")
			.headers(headers_11)
			.body(RawFileBody("dos5Application/user_research/0011_request.dat")))
		.pause(1)
		.exec(http("user_research_request_12")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/research-studio-size?hidden_text=Research+studio+size"))
		.pause(1)
		.exec(http("user_research_request_13")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/research-studio-size")
			.headers(headers_13)
			.body(RawFileBody("dos5Application/user_research/0013_request.dat")))
		.pause(1)
		.exec(http("user_research_request_14")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/viewing?hidden_text=Viewing"))
		.pause(1)
		.exec(http("user_research_request_15")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/viewing")
			.headers(headers_15)
			.body(RawFileBody("dos5Application/user_research/0015_request.dat")))
		.pause(1)
		.exec(http("user_research_request_16")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/technical-assistance?hidden_text=Technical+assistance"))
		.pause(1)
		.exec(http("user_research_request_17")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/technical-assistance")
			.headers(headers_17)
			.body(RawFileBody("dos5Application/user_research/0017_request.dat")))
		.pause(1)
		.exec(http("user_research_request_18")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/hospitality?hidden_text=Hospitality"))
		.pause(1)
		.exec(http("user_research_request_19")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/hospitality")
			.headers(headers_19)
			.body(RawFileBody("dos5Application/user_research/0019_request.dat")))
		.pause(1)
		.exec(http("user_research_request_20")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/facilities?hidden_text=Facilities"))
		.pause(1)
		.exec(http("user_research_request_21")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/facilities")
			.headers(headers_21)
			.body(RawFileBody("dos5Application/user_research/0021_request.dat")))
		.pause(1)
		.exec(http("user_research_request_22")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/accessibility?hidden_text=Accessibility"))
		.pause(1)
		.exec(http("user_research_request_23")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/accessibility")
			.headers(headers_23)
			.body(RawFileBody("dos5Application/user_research/0023_request.dat")))
		.pause(1)
		.exec(http("user_research_request_24")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/price?hidden_text=Price"))
		.pause(1)
		.exec(http("user_research_request_25")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/edit/price")
			.headers(headers_25)
			.body(RawFileBody("dos5Application/user_research/0025_request.dat")))
		.pause(1)
		.exec(http("user_research_request_26")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/complete")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}"))
		.pause(1)
		.exec(http("user_research_request_27")
			.get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}"))
		.pause(1)
		.exec(http("user_research_request_28")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/delete")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}"))
		.pause(1)
		.exec(http("user_research_request_29")
			.post("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions/user-research-studios/${service_id}/delete")
			.headers(headers_2)
			.formParam("csrf_token", "${csrf}")
			.formParam("delete_confirmed", "true"))
}