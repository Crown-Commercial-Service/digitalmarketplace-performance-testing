package gcloud11

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GCloud11Application extends Simulation {

  val httpProtocol = http
    .baseURL("https://www.preview.marketplace.team")
    .inferHtmlResources(BlackList(""".*\.js.*""", """.*\.css.*""", """.*\.gif.*""", """.*\.jpeg.*""", """.*\.jpg.*""", """.*\.ico.*""", """.*\.woff.*""", """.*\.(t|o)tf.*""", """.*\.png.*"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

  object SignUp {

    val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

    val headers_3 = Map(
      "Content-Type" -> "application/x-www-form-urlencoded; boundary=--WebKitFormBoundaryH2hTfwjGBpETaysO",
      "Origin" -> "http://localhost",
      "Upgrade-Insecure-Requests" -> "1")

    val headers_99 = Map(
      "Origin" -> "http://localhost",
      "Upgrade-Insecure-Requests" -> "1")

    var sp = System.getProperty("scalePauses").toDouble

    val sign_up = exec(http("Index")
      .get("/suppliers/supply")
      .headers(headers_0)
    )
      .pause((sp*11).toInt)
      .exec(http("Start page")
        .get("/suppliers/create/start")
        .headers(headers_0)
      )
      .pause((sp*11).toInt)
      .exec(http("DUNS number")
        .get("/suppliers/create/duns-number")
        .check(css("input[name=csrf_token]", "value").saveAs("csrf"))
        .headers(headers_0)
      )
      .pause((sp*11).toInt)
      .exec(http("Post DUNS number")
        .post("/suppliers/create/duns-number")
        .headers(headers_3)
        .formParamSeq(Seq(("duns_number", ""), ("csrf_token", "${csrf}")))
        .check(status.is(400))
      )
      .pause((sp*11).toInt)
      .exec(http("Contact details")
        .post("/suppliers/create/company-details")
        .formParam("company_name", "Gatling Co")
        .formParam("contact_name", "Gatling Contact")
        .formParam("email_address", "test@example.com")
        .formParam("phone_number", "07777777777")
        .formParam("csrf_token", "${csrf}")
        .headers(headers_3)
      )
      .pause((sp*11).toInt)
      .exec(http("Create login")
        .post("/suppliers/create/account")
        .formParamSeq(Seq(("email_address", "company@example.com"), ("csrf_token", "${csrf}")))
        .headers(headers_3)
      )
      .pause((sp*11).toInt)
      .exec(http("Check info")
        .post("/suppliers/create/company-summary")
        .formParam("csrf_token", "${csrf}")
        .check(status.is(400))
        .headers(headers_3)
      )
      .pause(1)

    val applyAsSupplier = exec(
      exitBlockOnFail {
        pause((sp*11).toInt)
          .exec(sign_up)
      }
    )
  }

  val scn = scenario("G-11 Supplier sign up").exec(SignUp.sign_up)

  setUp(scn.inject(rampUsers(3000) over (60 minutes)).protocols(httpProtocol))
}
