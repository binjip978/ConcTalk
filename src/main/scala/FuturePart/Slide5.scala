package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object Slide5 {
  def run: Unit = {
    val f1 = Future { 1 }
    val f2 = Future { 1 / 0 }
    val f3 = Future { 2 }

    val c = for {
      v1 <- f1
      v2 <- f2
      v3 <- f3
    } yield v1 + v2 + v3

    c onComplete {
      case Success(v) => println(v)
      case Failure(e) => println(s"error $e")
    }

    Thread.sleep(1000)
  }
}
