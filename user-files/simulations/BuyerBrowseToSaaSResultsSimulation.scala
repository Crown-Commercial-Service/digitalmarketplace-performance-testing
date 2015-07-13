
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BuyerBrowseToSaaSResultsSimulation extends Simulation with DigitalMarketplaceHttpConf {

	val httpProtocol = http
		.baseURL("https://www.beta.digitalmarketplace.service.gov.uk")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate, sdch")
		.acceptLanguageHeader("en-US,en;q=0.8")
		.connection("keep-alive")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.132 Safari/537.36")

	val headers_14 = Map(
		"accept" -> "image/webp,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, sdch",
		"accept-language" -> "en-US,en;q=0.8",
		"referer" -> "https://www.beta.digitalmarketplace.service.gov.uk/g-cloud",
		"user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.132 Safari/537.36")

	val headers_29 = Map("Accept" -> "image/webp,*/*;q=0.8")

	val headers_31 = Map(
		"accept" -> "image/webp,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, sdch",
		"accept-language" -> "en-US,en;q=0.8",
		"referer" -> "https://www.beta.digitalmarketplace.service.gov.uk/g-cloud/search?lot=saas",
		"user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.132 Safari/537.36")

    val uri2 = "https://www.beta.digitalmarketplace.service.gov.uk"

	val scn = scenario("BuyerBrowseToSaaSResultsSimulation")
		.exec(http("request_0")
			.get("/g-cloud")
			.resources(http("request_1")
			.get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0"),
            http("request_2")
			.get(uri2 + "/static/stylesheets/fonts.css?0.12.0"),
            http("request_3")
			.get(uri2 + "/static/stylesheets/application.css"),
            http("request_4")
			.get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0"),
            http("request_5")
			.get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0"),
            http("request_6")
			.get(uri2 + "/static/javascripts/govuk-template.js?0.12.0"),
            http("request_7")
			.get(uri2 + "/static/javascripts/application.js"),
            http("request_8")
			.get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0"),
            http("request_9")
			.get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0"),
            http("request_10")
			.get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0"),
            http("request_11")
			.get(uri2 + "/static/images/breadcrumb-separator.png")
			.headers(headers_14)))
		.pause(minIdleTime milliseconds, maxIdleTime milliseconds)
		.exec(http("request_15")
			.get("/g-cloud/search?lot=saas")
			.resources(http("request_16")
			.get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0"),
            http("request_17")
			.get(uri2 + "/static/stylesheets/fonts.css?0.12.0"),
            http("request_18")
			.get(uri2 + "/static/stylesheets/application.css"),
            http("request_19")
			.get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0"),
            http("request_20")
			.get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0"),
            http("request_21")
			.get(uri2 + "/static/images/breadcrumb-separator.png"),
            http("request_22")
			.get(uri2 + "/static/javascripts/govuk-template.js?0.12.0"),
            http("request_23")
			.get(uri2 + "/static/javascripts/application.js"),
            http("request_24")
			.get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0"),
            http("request_27")
			.get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0"),
            http("request_28")
			.get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0"),
            http("request_29")
			.get(uri2 + "/static/images/pagination-arrow-sprite.png")
			.headers(headers_29),
            http("request_30")
			.get(uri2 + "/static/images/option-select-toggle-sprite.png")
			.headers(headers_31)))

	setUp(scn.inject(atOnceUsers(numberOfUsers)).protocols(httpProtocol))
}