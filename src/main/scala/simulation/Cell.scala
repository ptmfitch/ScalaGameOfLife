package simulation

import geometry.Vector2

case class Cell (pos: Vector2, live: Boolean) {

  override def toString: String = if(live) "1" else "0"

  def liveNeighbours(board: Board): Int = pos.surrounding.count(p => board.cellAt(p).live)


}
