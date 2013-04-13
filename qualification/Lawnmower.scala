package qualification

import scala.io.Source
import java.io.PrintStream
import math._

object Lawnmower extends App {
  val src = Source.fromFile("B-large.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("B-large.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    val Seq(n, m) = src.next().split(" ").map(_.toInt).toSeq
    val board = src.take(n).map(_.split(" ").map(_.toInt)).toArray

    val horCuts = board.map(_.max)
    val verCuts = board.reduce(_.zip(_).map { p => max(p._1, p._2) })

    val success = (0 until n).forall { i =>
      (0 until m).forall { j =>
        board(i)(j) == min(horCuts(i), verCuts(j))
      }
    }
    out.println("Case #%d: %s".format(k, if(success) "YES" else "NO"))
  }
}
