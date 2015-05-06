package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide10 {
  def run: Unit = {
    def first[T](xs: List[Future[T]]): Future[T] = {
      val p = Promise[T]

      for {
        x <- xs
      } p.tryCompleteWith(x)

      p.future
    }

    val f = first(List(Future{ Thread.sleep(2000); 12 }, Future { new Exception }))

    f.foreach { case x => println(x) }

    Thread.sleep(5000)
  }
}
