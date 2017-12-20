package geometry

object Direction extends Enumeration {
  type Direction = Vector2
  val North: Vector2 = Vector2(0, -1)
  val South: Vector2 = Vector2(0, +1)
  val East:  Vector2 = Vector2(+1, 0)
  val West:  Vector2 = Vector2(-1, 0)
  val NorthEast: Vector2 = North + East
  val NorthWest: Vector2 = North + West
  val SouthEast: Vector2 = South + East
  val SouthWest: Vector2 = South + West
}

case class Vector2(x: Int, y: Int) {

  def +(that: Vector2) : Vector2 = Vector2(this.x + that.x, this.y + that.y)
  def -(that: Vector2) : Vector2 = Vector2(this.x - that.x, this.y - that.y)

  def surrounding: Seq[Vector2] = {
    val positions: Seq[Vector2] = -1 to 1 flatMap(y => -1 to 1 map(x => Vector2(this.x + x, this.y + y)))
    positions.filterNot(_ == this)
  }

}
