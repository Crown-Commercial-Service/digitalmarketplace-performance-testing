package utils

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration._

object ScenarioHelpers {

  implicit class Repeater(scenario: ScenarioBuilder) {
    def keepRepeating(chain: io.gatling.core.structure.ChainBuilder) = {
      SimulationProperties.repetitionUnit match {
        case RepetitionUnit.times => scenario.repeat(SimulationProperties.repeat)(chain)
        case RepetitionUnit.seconds => scenario.during(SimulationProperties.repeat seconds)(chain)
      }
    }
  }
}

