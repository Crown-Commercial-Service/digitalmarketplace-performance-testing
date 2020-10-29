import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import SupplierLogin.login
import dos5Application.UserResearch.user_research
import dos5Application.ConfirmDetails.confirm_details
import dos5Application.Declaration.declaration
import dos5Application.DigitalOutcomes.digital_outcomes
import dos5Application.DigitalSpecialists.digital_specialists
import dos5Application.UserResearchParticipants.user_research_participants


class Dos5Application extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost")
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png""", """.*\.woff2""", """.*detectportal\.firefox\.com.*"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")

  var scn = scenario("DOS 5 Application")
    .exec(login, confirm_details, digital_specialists, user_research_participants)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
