import com.typesafe.config.{ConfigFactory, Config}

object GameConfig {
  val config: Config = ConfigFactory.load
}
