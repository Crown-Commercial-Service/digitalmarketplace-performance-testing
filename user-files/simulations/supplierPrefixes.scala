import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SupplierPrefixes extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost")
    .inferHtmlResources(BlackList(""".*\.js.*""", """.*\.css.*""", """.*\.gif.*""", """.*\.jpeg.*""", """.*\.jpg.*""", """.*\.ico.*""", """.*\.woff.*""", """.*\.(t|o)tf.*""", """.*\.png.*"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")

  object Scrape {
    val prefixFeeder = (for (i <- 'A' until 'Z') yield {
      Map("prefix" -> i)
    })

    val scrape = feed(prefixFeeder.circular)
      .exec(http("Index")
      .get("/g-cloud/suppliers?prefix=${prefix}")
    )
  }

  val scn = scenario("Supplier data scraping").exec(Scrape.scrape)

  setUp(scn.inject(
    constantUsersPerSec(10) during (2 seconds)
  ).protocols(httpProtocol))
}
