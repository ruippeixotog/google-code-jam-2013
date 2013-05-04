package round1b

import java.io.PrintStream
import scala.io.Source
import math._

object FallingDiamonds extends App {
  val src = Source.fromFile("round1b/B-test.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("round1b/B-test.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    println("Case " + k)
    val Seq(n, x, y) = src.next().split(" ").toSeq.map(_.toInt)
    val layer = (abs(x) + abs(y)) / 2
    val layerSize = layer * 4 + 1
    val placeIdx = x + layer * 2

//    println("Layer " + layer)
    //    println("Size " + layerSize)
    //    println("Idx " + placeIdx)

    var nLeft = n
    (0 until layer).foreach { i => nLeft -= (i + 1) * 2 - 1 }

    println("Left " + nLeft)

    val prob =
      if(nLeft <= 0) 0.0
      else if(nLeft >= layerSize) 1.0
      else if(placeIdx == layerSize / 2) 0.0
      else {
        var p = new Array[Double](layerSize / 2)
        def not(i: Int) = 1 - p(i)

        (1 to nLeft).foreach { j =>
          val newP = p.clone()

          (0 until p.length).foreach { i =>
            val notPrev = if(i == 0) 0.0 else not(i - 1)
            newP(i) += (not(i) - notPrev) * not(p.length - 1) * 0.5 + p(p.length - 1)
          }
        println("After drop " + j + ": " + p.mkString(", "))
          p = newP
        }

        min(1.0,
          p(if(placeIdx > layerSize / 2) layerSize - placeIdx - 1 else placeIdx))
      }

    out.println("Case #%d: %s".format(k, prob))
  }
}
