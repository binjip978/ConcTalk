package FuturePart

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide11 {
  def run: Unit = {
    val urlSpecSize = Future {
      val url = "http://www.scala-lang.org"
      scala.io.Source.fromURL(url).size
    }

    // how much we should wait until exception
    val size = Await.result(urlSpecSize, 10 seconds)
    println(size)
  }
}
