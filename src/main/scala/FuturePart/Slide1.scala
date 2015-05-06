package FuturePart
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide1 {
  def run: Unit = {
    //trait Future[T]
    //def apply[T](b: =>T)(implicit e: ExecutionContext): Future[T]

    val f = Future { println("Hello World!") }
    println(f.isCompleted)
    Thread.sleep(1000)
    println(f.isCompleted)

    //      [info] Running Main
    //      [info] Hello World!
    //      [info] false
    //      [info] true

    // Future happens before polling calls

  }

}
