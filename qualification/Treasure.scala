package qualification

import scala.io.Source
import java.io.PrintStream

object Treasure extends App {
  val src = Source.fromFile("qualification/D-test.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("qualification/D-test.out")
  val t = src.next().toInt

  (1 to t).foreach { tc =>
    val Seq(_, n) = src.next().split(" ").map(_.toInt).toSeq

    val initialKeys = src.next().split(" ").map(_.toInt).toArray.sorted
    val (chestTypes, chestKeys) = src.take(n).map(_.split(" ").map(_.toInt)).map {
      arr => (arr.head, arr.tail.tail) }.toArray.unzip

    out.println("Case #%d: %s".format(tc, "TODO"))
  }
}
