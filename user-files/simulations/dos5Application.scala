import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import SupplierLogin.login
import dos5Application.ConfirmDetails.confirm_details
import dos5Application.Declaration.declaration
import dos5Application.DigitalOutcomes.digital_outcomes
import dos5Application.DigitalSpecialists.digital_specialists
import dos5Application.UserResearchParticipants.user_research_participants
import dos5Application.UserResearch.user_research
import dos5Application.AdditionalGets.additional_gets

class Dos5Application extends Simulation {
  val httpProtocol = http
    .baseUrl("https://www.staging.marketplace.team/")
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png""", """.*\.woff2""", """.*detectportal\.firefox\.com.*"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")

  var digitalServiceSupplier = scenario("Digital Service Supplier")
    .exec(login, confirm_details, declaration, digital_outcomes, digital_specialists, user_research_participants, additional_gets)

  var userResearchStudioSupplier = scenario("UR Studio Supplier")
    .exec(login, confirm_details, declaration, user_research, user_research, user_research, additional_gets)

  val testDuration = FiniteDuration(60, MINUTES)
  val testCutOff = FiniteDuration(65, MINUTES)

  val basePredictedRatePerMinute = 0.5
  val scaleFactor = 4

  val digitalServiceUsers = (2.0/3 * basePredictedRatePerMinute * testDuration.toMinutes * scaleFactor).toInt
  val userResearchUsers = (1.0/3 * basePredictedRatePerMinute * testDuration.toMinutes * scaleFactor).toInt

  setUp(
    digitalServiceSupplier.inject(
      rampUsers(digitalServiceUsers) during (testDuration)
    ).exponentialPauses,
    userResearchStudioSupplier.inject(
      rampUsers(userResearchUsers) during (testDuration)
    ).exponentialPauses,
  ).protocols(httpProtocol).maxDuration(testCutOff)
}
