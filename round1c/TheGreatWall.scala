
import java.io.PrintStream
import scala.collection.mutable
import scala.io.Source

object TheGreatWall extends App {
  case class Tribe(di: Int, ni: Int, wi: Int, ei: Int, si: Int, dd: Int, pd: Int, sd: Int, id: Int) extends Ordered[Tribe] {
    def compare(that: Tribe): Int = if(di != that.di) that.di - di else that.id - id

    def afterAttack: Tribe = Tribe(di + dd, ni - 1, wi + pd, ei + pd, si + sd, dd, pd, sd, id)
  }

  val src = Source.fromFile("round1c/C-small.in").getLines().filterNot(_.isEmpty)
  val out = new PrintStream("round1c/C-small.out")
  val t = src.next().toInt

  (1 to t).foreach { k =>
    println("Case " + k)
    val n = src.next().toInt
    val tribes = (1 to n).map { i =>
      val Seq(di, ni, wi, ei, si, dd, pd, sd) = src.next().split(" ").toSeq.map(_.toInt)
      Tribe(di, ni, wi, ei, si, dd, pd, sd, i)
    }

    var wall = new Array[Int](0)
    val center = 500 / 2

    val queue = mutable.PriorityQueue[Tribe](tribes: _*)

    var count = 0
    var d = -1
    var newWall = new Array[Int](500)

    while(queue.nonEmpty) {
      val tribe = queue.dequeue()
      require(tribe.di >= d)

      if(d != tribe.di) {
        wall = newWall
        newWall = wall.clone()
        d = tribe.di
      }

      val attacks = (center + tribe.wi until center + tribe.ei).filter(wall(_) < tribe.si)
      if(attacks.nonEmpty) {
        count += 1
      }
      attacks.foreach { i => if(newWall(i) < tribe.si) newWall(i) = tribe.si }

      if(tribe.ni > 1) queue.enqueue(tribe.afterAttack)
    }

    out.println("Case #%d: %s".format(k, count))
  }
}
