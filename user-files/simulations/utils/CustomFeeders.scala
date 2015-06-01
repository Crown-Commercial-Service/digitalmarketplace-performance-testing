package utils

import java.util.Random

import org.apache.commons.lang.RandomStringUtils

import io.gatling.core.Predef._

object CustomFeeders {

  val r = new Random()

  val searchTerms = csv("search-terms.csv").random

  val supplierIds = csv("supplier_ids.csv").random

  val serviceIds = csv("service_ids.csv").random

  val randomServiceId = new Feeder[String]{
    def hasNext: Boolean = true

    def next(): Map[String, String] = {
      Map("random_number" -> RandomStringUtils.random(16, false, true))
    }
  }

  val randomPage = new Feeder[String]{
    def hasNext: Boolean = true

    def next(): Map[String, String] = {
      Map("random_page" -> String.valueOf(r.nextInt(50) + 1))
    }
  }
}
