package net.ceedubs.ficus

import com.typesafe.config.{Config, ConfigFactory}
import net.ceedubs.ficus.FicusConfig._
import scala.concurrent.duration.FiniteDuration

class Examples {
  val config: Config = ConfigFactory.load() // standard Typesafe Config

  // Note: explicit typing isn't necessary. It's just in these examples to make it clear what the return types are.
  // This line could instead be: val appName = config.getAs[String]("app.name")
  val appName: String = config.getAs[String]("app.name") // equivalent to config.getString("app.name")

  // config.getAs[Option[Boolean]]("preloadCache") will return None if preloadCache isn't defined in the config
  val preloadCache: Boolean = config.getAs[Option[Boolean]]("preloadCache").getOrElse(false)

  val adminUserIds: Set[Long] = config.getAs[Set[Long]]("adminIds")

  // something such as "15 minutes" can be converted to a FiniteDuration
  val retryInterval: FiniteDuration = config.getAs[FiniteDuration]("retryInterval")
}