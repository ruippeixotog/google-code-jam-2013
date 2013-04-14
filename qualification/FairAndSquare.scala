package qualification

import scala.io.Source
import java.io.PrintStream
import java.util._

object FairAndSquare extends App {
  val src = Source.fromFile("qualification/C-large-1.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("qualification/C-large-1.out")

  def isPalindrome(s: String) = (0 until s.length / 2).forall { i => s(i) == s(s.length - i - 1) }
  val mem = (1 to 10000000).
    filter { i => isPalindrome(i.toString) }.
    map { i => i * i.toLong }.
    filter { i => isPalindrome(i.toString) }.toArray

  val t = src.next().toInt

  (1 to t).foreach { k =>
    val Seq(a, b) = src.next().split(" ").map(_.toLong).toSeq

    val pa = Arrays.binarySearch(mem, 0, mem.length, a)
    val pb = Arrays.binarySearch(mem, 0, mem.length, b)
    val ra = if(pa >= 0) pa else -pa - 1
    val rb = if(pb >= 0) pb else -pb - 2

    out.println("Case #%d: %d".format(k, rb - ra + 1))
  }
}
