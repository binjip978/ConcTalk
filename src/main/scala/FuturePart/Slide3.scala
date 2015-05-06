package FuturePart
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object Slide3 {
  def run: Unit ={
    val f: Future[Int] = Future { 1 / 0 }

    f onComplete {
      case Success(v) => println("Surprise!")
      case Failure(e) => println(s"Error: $e")
    }

    Thread.sleep(1000)
  }
}
