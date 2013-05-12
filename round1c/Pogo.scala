
import java.io.PrintStream
import scala.io.Source

object Pogo extends App {
  val src = Source.fromFile("round1c/B-small.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("round1c/B-small.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    println("Case " + k)
    val Seq(x, y) = src.next().split(" ").toSeq.map(_.toInt)

    val xPath =
      (if(x > 0) (1 to x).map(_ => "WE")
      else (1 to -x).map(_ => "EW")).reduceOption(_ + _).getOrElse("")

    val yPath =
      (if(y > 0) (1 to y).map(_ => "SN")
      else (1 to -y).map(_ => "NS")).reduceOption(_ + _).getOrElse("")

    out.println("Case #%d: %s".format(k, xPath + yPath))
  }
}
