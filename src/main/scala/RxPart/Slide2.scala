package RxPart

import rx.lang.scala._

import scala.concurrent.duration._

object Slide2 {
  def run: Unit = {
    val o: Observable[Long] = Observable.timer(2 second)
    o.subscribe(x => println(x))
    o.subscribe(x => println(x + 1000))

    Thread.sleep(5000)
  }
}
