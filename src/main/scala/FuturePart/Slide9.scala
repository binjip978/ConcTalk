package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object Slide9 {
  def run: Unit = {
    val p = Promise[String]
    val q = Promise[String]

    p.future foreach { case x => println(x)}
    q.future.failed foreach { case e => println(s"error: " + e)}

    p.complete(Success("Promise complete"))
    q.complete(Failure(new Exception))

    val z = Promise[Int]

    z.future onComplete {
      case Success(v) => println(v)
      case Failure(e) => println(s"Error: $e")
    }

    z.complete(Try(1 / 0))

    Thread.sleep(2000)
  }
}
