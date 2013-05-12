import java.io.PrintStream
import scala.io.Source

object Consonants extends App {
  val vowels = Set('a', 'e', 'i', 'o', 'u')

  val src = Source.fromFile("round1c/A-small.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("round1c/A-small.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    println("Case " + k)
    val Seq(word, nStr) = src.next().split(" ").toSeq
    val n = nStr.toInt

    val seq = word.map(vowels.contains(_))
    val nSeq = (1 to n).map(_ => false)

    var count = 0

    var i = 0
    while(i != -1) {
      val nextSeq = seq.indexOfSlice(nSeq, i)
      if(nextSeq != -1) {
        count += (nextSeq - i + 1) * (seq.length - nextSeq - n + 1)
        i = nextSeq + 1
      } else {
        i = nextSeq
      }
    }

    out.println("Case #%d: %d".format(k, count))
  }
}
