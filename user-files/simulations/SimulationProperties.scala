import com.typesafe.config.{ConfigFactory, Config}
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

/**
 * Environment properties set up before the run.
 */

object SimulationProperties{
  val conf = ConfigFactory.load("simulation.conf")

  val baseLocateUrl = getStringFromConf("url")

  val bearerToken = "Bearer " + getStringFromConf("token")

  val numberOfUsers = getIntFromConf("users")
  val rampUpTime =  getIntFromConf("rampUp")
  val repeat = getIntFromConf("repeat")
  val repetitionUnit = getStringFromConf("unit") match {
    case  "times" => RepetitionUnit.times
    case "seconds" => RepetitionUnit.seconds
    case unknown => throw new IllegalArgumentException(s"Unknown unit: '$unknown'. Available: times|seconds")
  }

  val minIdleTime = getIntFromConf("minIdleTime")
  val maxIdleTime = getIntFromConf("maxIdleTime")
  val date = Option(System.getProperty("date"))
    .map(DateTime.parse(_, DateTimeFormat.forPattern("yyyy-MM-dd")))
    .getOrElse(DateTime.now().minusDays(1))
    .toDateMidnight
  val username = Option(System.getProperty("username")).getOrElse("user")
  val password = Option(System.getProperty("password")).getOrElse("password")
  val authHeaderData = Option(System.getProperty("authHeaderData")).getOrElse("user:password")

  private def getIntFromConf(name: String) = Option(Integer.getInteger(name)).map(_.toInt).getOrElse(conf.getInt(name))
  private def getStringFromConf(name: String) = Option(System.getProperty(name)).getOrElse(conf.getString(name))
}

object RepetitionUnit extends Enumeration {
  type RepetitionUnit = Value

  val times, seconds = Value
}
