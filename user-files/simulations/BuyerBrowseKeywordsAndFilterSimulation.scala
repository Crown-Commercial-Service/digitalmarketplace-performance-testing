
import scenarios.BuyerAppScenarios._
import utils.DigitalMarketplaceHttpConf
import utils.SimulationProperties._
import utils.ScenarioHelpers._
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._


class BuyerBrowseKeywordsAndFilterSimulation extends Simulation with DigitalMarketplaceHttpConf {

  val httpProtocol = http
    .baseURL("https://www.beta.digitalmarketplace.service.gov.uk")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, sdch")
    .acceptLanguageHeader("en-US,en;q=0.8")
    .connection("keep-alive")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.132 Safari/537.36")

  val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")

  val headers_1 = Map(
    "Accept" -> "text/css,*/*;q=0.1",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache")

  val headers_5 = Map(
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache")

  val headers_6 = Map(
    "Accept" -> "*/*",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache")

  val uri2 = "https://www.beta.digitalmarketplace.service.gov.uk"

  val scn = scenario("BuyerBrowseKeywordsAndFilterSimluation")
    .keepRepeating {
    exec(http("request_0")
      .get("/g-cloud/search?q=email+services")
      .headers(headers_0)
      .resources(http("request_1")
      .get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0")
      .headers(headers_1),
        http("request_2")
          .get(uri2 + "/static/stylesheets/fonts.css?0.12.0")
          .headers(headers_1),
        http("request_3")
          .get(uri2 + "/static/stylesheets/application.css")
          .headers(headers_1),
        http("request_4")
          .get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0")
          .headers(headers_1),
        http("request_5")
          .get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0")
          .headers(headers_5),
        http("request_6")
          .get(uri2 + "/static/javascripts/govuk-template.js?0.12.0")
          .headers(headers_6),
        http("request_7")
          .get(uri2 + "/static/javascripts/application.js")
          .headers(headers_6),
        http("request_8")
          .get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0")
          .headers(headers_5),
        http("request_9")
          .get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0")
          .headers(headers_5),
        http("request_10")
          .get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0")
          .headers(headers_5),
        http("request_11")
          .get(uri2 + "/static/images/search-result-highlight-mask.png"),
        http("request_12")
          .get(uri2 + "/static/images/pagination-arrow-sprite.png"),
        http("request_13")
          .get(uri2 + "/static/images/breadcrumb-separator.png"),
        http("request_16")
          .get(uri2 + "/static/images/option-select-toggle-sprite.png")))
      .pause(minIdleTime milliseconds, maxIdleTime milliseconds)
      .exec(http("request_18")
      .get("/g-cloud/search?q=email+services&lot=saas")
      .headers(headers_0)
      .resources(http("request_19")
      .get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0")
      .headers(headers_1),
        http("request_20")
          .get(uri2 + "/static/stylesheets/fonts.css?0.12.0")
          .headers(headers_1),
        http("request_21")
          .get(uri2 + "/static/stylesheets/application.css")
          .headers(headers_1),
        http("request_22")
          .get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0")
          .headers(headers_5),
        http("request_23")
          .get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0")
          .headers(headers_1),
        http("request_24")
          .get(uri2 + "/static/javascripts/govuk-template.js?0.12.0")
          .headers(headers_6),
        http("request_25")
          .get(uri2 + "/static/javascripts/application.js")
          .headers(headers_6),
        http("request_26")
          .get(uri2 + "/static/images/breadcrumb-separator.png"),
        http("request_27")
          .get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0")
          .headers(headers_5),
        http("request_28")
          .get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0")
          .headers(headers_5),
        http("request_29")
          .get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0")
          .headers(headers_5),
        http("request_30")
          .get(uri2 + "/static/images/search-result-highlight-mask.png"),
        http("request_31")
          .get(uri2 + "/static/images/pagination-arrow-sprite.png")))
      .pause(minIdleTime milliseconds, maxIdleTime milliseconds)
      .exec(http("request_36")
      .get("/g-cloud/search?q=email+services&lot=saas&freeOption=true&trialOption=true")
      .headers(headers_0)
      .resources(http("request_37")
      .get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0")
      .headers(headers_1),
        http("request_38")
          .get(uri2 + "/static/stylesheets/fonts.css?0.12.0")
          .headers(headers_1),
        http("request_39")
          .get(uri2 + "/static/stylesheets/application.css")
          .headers(headers_1),
        http("request_40")
          .get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0")
          .headers(headers_5),
        http("request_41")
          .get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0")
          .headers(headers_1),
        http("request_42")
          .get(uri2 + "/static/javascripts/govuk-template.js?0.12.0")
          .headers(headers_6),
        http("request_43")
          .get(uri2 + "/static/javascripts/application.js")
          .headers(headers_6),
        http("request_44")
          .get(uri2 + "/static/images/breadcrumb-separator.png"),
        http("request_47")
          .get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0")
          .headers(headers_5),
        http("request_48")
          .get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0")
          .headers(headers_5),
        http("request_49")
          .get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0")
          .headers(headers_5),
        http("request_50")
          .get(uri2 + "/static/images/search-result-highlight-mask.png"),
        http("request_51")
          .get(uri2 + "/static/images/option-select-toggle-sprite.png")))
      .pause(minIdleTime milliseconds, maxIdleTime milliseconds)
      .exec(http("request_53")
      .get("/g-cloud/search?q=email+services&lot=saas&serviceTypes=customer+relationship+management+%28crm%29&freeOption=true&trialOption=true")
      .headers(headers_0)
      .resources(http("request_54")
      .get(uri2 + "/static/stylesheets/govuk-template.css?0.12.0")
      .headers(headers_1),
        http("request_55")
          .get(uri2 + "/static/stylesheets/fonts.css?0.12.0")
          .headers(headers_1),
        http("request_56")
          .get(uri2 + "/static/stylesheets/application.css")
          .headers(headers_1),
        http("request_57")
          .get(uri2 + "/static/images/gov.uk_logotype_crown.png?0.12.0")
          .headers(headers_5),
        http("request_58")
          .get(uri2 + "/static/javascripts/govuk-template.js?0.12.0")
          .headers(headers_6),
        http("request_59")
          .get(uri2 + "/static/javascripts/application.js")
          .headers(headers_6),
        http("request_60")
          .get(uri2 + "/static/stylesheets/govuk-template-print.css?0.12.0")
          .headers(headers_1),
        http("request_61")
          .get(uri2 + "/static/images/breadcrumb-separator.png"),
        http("request_62")
          .get(uri2 + "/static/images/search-result-highlight-mask.png"),
        http("request_63")
          .get(uri2 + "/static/stylesheets/external-links/external-link.png?0.12.0")
          .headers(headers_5),
        http("request_64")
          .get(uri2 + "/static/stylesheets/images/open-government-licence.png?0.12.0")
          .headers(headers_5),
        http("request_65")
          .get(uri2 + "/static/stylesheets/images/govuk-crest.png?0.12.0")
          .headers(headers_5)))
  }
  setUp(scn.inject(atOnceUsers(numberOfUsers)).protocols(httpProtocol))
}