package utils

import java.util.Random

import org.apache.commons.lang.RandomStringUtils

import io.gatling.core.Predef._

object CustomFeeders {

  val r = new Random()

  val searchTerms = csv("search-terms.csv").random

  val supplierIds = csv("supplier_ids.csv").random

  val serviceIds = csv("service_ids.csv").random

  private def randomIdFeeder(idSize:Int): Feeder[String] = {
    new Feeder[String]{
      def hasNext: Boolean = true

      def next(): Map[String, String] = {
        Map("random_number" -> RandomStringUtils.random(idSize, false, true))
      }
    }
  }

  val randomServiceId = randomIdFeeder(16)

  val randomSupplierId = randomIdFeeder(5)

  /**
   * Generate a random page number between 1 and the maxPageSize provided.
   *
   * @param maxPageSize
   * @return Feeder[String]
   */
  private def randomPage(maxPageSize:Int): Feeder[String] = {
    new Feeder[String] {
      def hasNext: Boolean = true

      def next(): Map[String, String] = {
        Map("random_page" -> String.valueOf(r.nextInt(maxPageSize) + 1))
      }
    }
  }

  val randomServicePage = randomPage(50)

  val randomSupplierPage = randomPage(10)
}
