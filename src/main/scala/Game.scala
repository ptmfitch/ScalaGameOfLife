import geometry.Vector2
import simulation.{Board, Cell}

import scala.io.Source

object Game extends App {

  val fileName: String = "spawner1.txt"

  def readBoard(file: String): Board = Board {
    Source.fromFile(s"${GameConfig.boardDir}/$file").getLines()
      .map(s => s.toCharArray.map(c => c == '1').zipWithIndex).zipWithIndex
      .map(y => y._1.map(x => Cell(Vector2(x._2, y._2), x._1))).toArray
  }

  val board: Board = readBoard(fileName)
  println(board)

  //TODO: count generations and have possible max
  while(board.liveCells() > GameConfig.minCells) {
    println
    Thread.sleep(GameConfig.delay)
    board.nextGeneration()
    println(board)
  }
}
