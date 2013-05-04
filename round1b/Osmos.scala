package round1b

import scala.io.Source
import java.io.PrintStream

object Osmos extends App {
  val src = Source.fromFile("round1b/A-large.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("round1b/A-large.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    println("Case " + k)
    val Seq(a, _) = src.next().split(" ").toSeq.map(_.toInt)
    val motes = src.next().split(" ").toSeq.map(_.toInt).sorted

    def growSize(currA: Int, remMotes: Seq[Int], growCount: Int = 0, consumed: Int = 0): Option[(Int, Int, Seq[Int])] = {
      if(growCount < consumed) Some(growCount, currA, remMotes)
      else if(currA == 1 || remMotes.isEmpty) None
      else {
        var newA = currA
        var growTimes = 0
        while(newA <= remMotes.head) {
          newA += newA - 1
          growTimes += 1
        }

        var newRemMotes = remMotes
        var absorved = 0
        while(newRemMotes.nonEmpty && newA > newRemMotes.head) {
          newA += newRemMotes.head
          newRemMotes = newRemMotes.tail
          absorved += 1
        }

        growSize(newA, newRemMotes, growCount + growTimes, consumed + absorved)
      }
    }

    var moves = 0
    var currA = a
    var currMotes = motes
    var grow = growSize(currA, currMotes)

    while(grow != None) {
      val Some((growMoves, newA, newRemMotes)) = grow

      moves += growMoves
      currA = newA
      currMotes = newRemMotes
      grow = growSize(currA, currMotes)
    }

    moves += currMotes.length
    out.println("Case #%d: %d".format(k, moves))
  }
}
