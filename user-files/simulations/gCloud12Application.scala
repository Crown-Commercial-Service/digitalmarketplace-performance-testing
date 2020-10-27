import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import SupplierLogin.login
import gCloud12Application.UpdateSupplerDetails.updateSupplierDetails
import gCloud12Application.Declaration.declaration
import gCloud12Application.CloudHostingService.cloudHostingService
import gCloud12Application.CloudSoftwareService.cloudSoftwareService
import gCloud12Application.CloudSupportService.cloudSupportService

class GCloud12Application extends Simulation {

	val httpProtocol = http
		.baseUrl(System.getProperty("baseUrl"))
		.inferHtmlResources(BlackList(""".*\.js.*""", """.*\.css.*""", """.*\.gif.*""", """.*\.jpeg.*""", """.*\.jpg.*""", """.*\.ico.*""", """.*\.woff.*""", """.*\.(t|o)tf.*""", """.*\.png.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

	var scn = scenario("G-Cloud 12 Application")
		.exec(login, updateSupplierDetails, declaration)
		.forever() {
			uniformRandomSwitch(
				exec(cloudHostingService),
				exec(cloudSoftwareService),
				exec(cloudSupportService)
			)
		}

	var initialUserRate = System.getProperty("initialUserRate").toDouble
	var initialUserDuration = new FiniteDuration(java.lang.Long.getLong("initialUserDuration"), java.util.concurrent.TimeUnit.SECONDS)
	var secondaryUsersCount = Integer.getInteger("secondaryUsersCount")
	var secondaryUserRamp = Integer.getInteger("secondaryUserRamp")
	var secondaryUserDuration = new FiniteDuration(java.lang.Long.getLong("secondaryUserDuration"), java.util.concurrent.TimeUnit.SECONDS)
	var secondaryUserPause = new FiniteDuration(java.lang.Long.getLong("secondaryUserPause"), java.util.concurrent.TimeUnit.SECONDS)
	var testDuration = new FiniteDuration(java.lang.Long.getLong("testDuration"), java.util.concurrent.TimeUnit.MINUTES)


	setUp(
	  scn.inject(
	    constantUsersPerSec(initialUserRate) during (initialUserDuration) randomized,
	    nothingFor(20 seconds),
			rampUsers(secondaryUsersCount) during (secondaryUserDuration)
	  ).exponentialPauses
	).protocols(httpProtocol).maxDuration(testDuration)
}
