import com.typesafe.config.{ConfigFactory, Config}

object GameConfig {
  val config: Config = ConfigFactory.load
  lazy val delay: Long = config.getLong("delay")
  lazy val boardDir: String = config.getString("boardDir")
  lazy val minCells: Int = config.getInt("minCells")
}
