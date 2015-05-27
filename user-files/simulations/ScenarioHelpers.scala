import io.gatling.core.structure.ScenarioBuilder
import scala.concurrent.duration._
import SimulationProperties.{repetitionUnit, repeat}
import io.gatling.core.Predef._

object ScenarioHelpers {

  implicit class Repeater(scenario: ScenarioBuilder) {
    def keepRepeating(chain: io.gatling.core.structure.ChainBuilder) = {
      repetitionUnit match {
        case RepetitionUnit.times => scenario.repeat(repeat)(chain)
        case RepetitionUnit.seconds => scenario.during(repeat seconds)(chain)
      }
    }
  }
}

