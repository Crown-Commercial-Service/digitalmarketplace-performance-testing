package utils

import SimulationProperties._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

trait DigitalMarketplaceHttpConf {

  private val headersMap = Map("Authorization" -> bearerToken)

  val wwwHttpConf = http
    .baseURL(baseBuyerUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .disableCaching

  val dataApiHttpConf = http
    .baseURL(baseDataApiUrl)
    .acceptHeader("application/json")
    .disableFollowRedirect
    .disableCaching
    .headers(headersMap)
}
