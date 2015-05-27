import com.ning.http.util.Base64
import io.gatling.core.result.message.KO
import io.gatling.http.Predef._
import simulations.SimulationProperties._

trait DigitalMarketplaceHttpConf {

  private val headersMap = Map("Authorization" -> bearerToken)

  val httpConf = http
    .baseURL(baseLocateUrl)
    .acceptHeader("application/json")
    .disableFollowRedirect
    .baseHeaders(headersMap)
}
