package FuturePart

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, blocking }
import scala.concurrent.ExecutionContext.Implicits.global

object Slide12 {
  def run: Unit = {
    val startTime = System.nanoTime

    val futures = for (_ <- 0 to 16) yield Future {
      blocking {
        Thread.sleep(2000)
      }
    }

    //      Total time: = 2139 ms
    //      Total time: = 10154 ms

    for (f <- futures) Await.ready(f, Duration.Inf)
    val endTime = System.nanoTime
    println(s"Total time: = ${(endTime - startTime) / 1000000 } ms")
    println(s"Total  CPU: = ${Runtime.getRuntime.availableProcessors}")
  }
}
