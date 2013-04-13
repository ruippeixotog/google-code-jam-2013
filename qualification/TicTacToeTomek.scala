package qualification

import scala.io.Source
import java.io.PrintStream

object TicTacToeTomek extends App {
  val src = Source.fromFile("A-large.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("A-large.out")
  val t = src.next().toInt

  val map = Map('X' -> List(0), 'O' -> List(1), 'T' -> List(0, 1), '.' -> Nil)

  (1 to t).foreach { k =>
    val board = src.take(4).toArray
    val counters = Array.ofDim[Int](2, 10)

    for (i <- 0 until 4; j <- 0 until 4; cnt <- map(board(i)(j))) {
      counters(cnt)(i) += 1
      counters(cnt)(4 + j) += 1
      if(i == j) counters(cnt)(8) += 1
      if(i + j == 3) counters(cnt)(9) += 1
    }

    val status =
      if (counters(0).contains(4)) "X won"
      else if (counters(1).contains(4)) "O won"
      else if (board.exists(_.contains('.'))) "Game has not completed"
      else "Draw"

    out.println("Case #%d: %s".format(k, status))
  }
}