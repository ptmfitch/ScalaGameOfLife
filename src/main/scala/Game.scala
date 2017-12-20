import geometry.Vector2
import simulation.{Board, Cell}

import scala.io.Source

object Game extends App {

  def readBoard(file: String): Board = Board {
    Source.fromFile(file).getLines()
      .map(s => s.toCharArray.map(c => c == '1').zipWithIndex).zipWithIndex
      .map(y => y._1.map(x => Cell(Vector2(x._2, y._2), x._1))).toArray
  }

  val board: Board = readBoard("spawner1.txt")
  println(board)

  while(board.liveCells() > 3) {
    println
    Thread.sleep(500)
    board.nextGeneration()
    println(board)
  }
}
