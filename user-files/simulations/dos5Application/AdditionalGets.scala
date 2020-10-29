package dos5Application

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object AdditionalGets {
  // Each supplier needs to make 120 additional GET requests to match the number of GET requests made by DOS users.
  val additional_gets = repeat(60) {
    exec(http("View supplier details").get("/suppliers/details"))
      .pause(1)
      .exec(http("View submissions").get("/suppliers/frameworks/digital-outcomes-and-specialists-5/submissions"))
      .pause(1)
  }
}