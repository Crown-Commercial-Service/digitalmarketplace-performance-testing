import io.gatling.core.Predef._

object CustomFeeders {
  val searchTerms = csv("search-terms.csv").random
}
