import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import gCloud10Application.Login.login
import gCloud10Application.UpdateSupplerDetails.updateSupplierDetails
import gCloud10Application.Declaration.declaration
import gCloud10Application.CloudHostingService.cloudHostingService
import gCloud10Application.CloudSoftwareService.cloudSoftwareService
import gCloud10Application.CloudSupportService.cloudSupportService

class GCloud10Application extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost")
		.inferHtmlResources(BlackList(""".*\.js.*""", """.*\.css.*""", """.*\.gif.*""", """.*\.jpeg.*""", """.*\.jpg.*""", """.*\.ico.*""", """.*\.woff.*""", """.*\.(t|o)tf.*""", """.*\.png.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

	var scn = scenario("G-Cloud 10 Application")
		.exec(login, updateSupplierDetails, declaration)
		.forever() {
			exec(cloudHostingService, cloudSoftwareService, cloudSupportService)
		}

	setUp(
	  scn.inject(
	    constantUsersPerSec(2) during (100 seconds) randomized,
	    nothingFor(20 seconds),
	    splitUsers(200) into (rampUsers(10) over (7 seconds)) separatedBy (13 seconds)
	  ).exponentialPauses
	).protocols(httpProtocol).maxDuration(11 minutes)
}
