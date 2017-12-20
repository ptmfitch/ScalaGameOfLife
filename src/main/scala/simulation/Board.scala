package simulation

import geometry.Vector2

case class Board(var grid: Array[Array[Cell]]) {

  override def toString: String = grid.map(_.mkString).mkString("\n")

  def liveCells(): Int = grid.map(_.count(_.live)).sum

  def cellAt(pos: Vector2): Cell = {
    val normalizedY: Int = if(pos.y < 0) pos.y + grid.length else pos.y % grid.length
    val row: Array[Cell] = grid.apply(normalizedY)
    val normalizedX: Int = if(pos.x < 0) pos.x + row.length else pos.x % row.length
    row.apply(normalizedX)
  }

  def nextGeneration(): Unit = {
    this.grid = this.grid.map(_.map(c => c.liveNeighbours(this) match {
      case n if n < 2 => Cell(c.pos, live = false)
      case 2 => Cell(c.pos, c.live)
      case 3 => Cell(c.pos, live = true)
      case n if n > 3 => Cell(c.pos, live = false)
    }))
  }

}
