package qualification

import scala.io.Source
import java.io.PrintStream
import java.util._
import java.math.BigInteger

object FairAndSquare extends App {

  def evenGen(size: Int, prefix: String = "", minDigit: Int = 1, currSum: Int = 0): Stream[String] =
    if(currSum >= 10) Stream.empty
    else if(size == 0) Stream(prefix + prefix.reverse)
    else (minDigit to 2).toStream.flatMap { d => evenGen(size - 1, prefix + d, 0, currSum + 2 * d * d) }

  def oddGen(size: Int, prefix: String = "", minDigit: Int = 1, currSum: Int = 0): Stream[String] =
    if(currSum >= 10) Stream.empty
    else if(size == 1) (0 to 2).toStream.flatMap { d => oddCenterGen(prefix, d, currSum + d * d) }
    else (minDigit to 2).toStream.flatMap { d => oddGen(size - 1, prefix + d, 0, currSum + 2 * d * d) }

  def oddCenterGen(prefix: String = "", last: Int, currSum: Int = 0): Stream[String] =
    if(currSum >= 10) Stream.empty
    else Stream(prefix + last + prefix.reverse)

  val mem = ("1" +: "2" +: "3" +: (2 to 50).flatMap { size =>
    if(size % 2 == 0) evenGen(size / 2) else oddGen(size / 2 + 1)
  }).map { n => new BigInteger(n).multiply(new BigInteger(n)).asInstanceOf[Object] }.toArray

  val src = Source.fromFile("qualification/C-large-2.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("qualification/C-large-2.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    val Seq(a, b) = src.next().split(" ").map(new BigInteger(_)).toSeq

    val pa = Arrays.binarySearch(mem, a)
    val pb = Arrays.binarySearch(mem, b)
    val ra = if(pa >= 0) pa else -pa - 1
    val rb = if(pb >= 0) pb else -pb - 2

    out.println("Case #%d: %d".format(k, rb - ra + 1))
  }
}
