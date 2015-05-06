package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object Slide8 {
  def run: Unit = {
    val f1: Future[Int] = Future { 1 / 0 }

    val f2: Future[Any] = f1.recover {
      case (exp) => s"error happend: $exp"
    }

    f2.onComplete {
      case Success(v) => println(s"if success: $v")
      case Failure(e) => println(s"if failure: $e")
    }

    Thread.sleep(1000)
  }
}
