package RxPart

import rx.lang.scala._

import scala.concurrent.duration._

object Slide8 {
  def run: Unit = {
    val odds = Observable.interval(0.5 seconds)
      .filter(x => x % 2 == 1).map(x => s"num $x").take(5)

    odds.subscribe(str => println(str))

    Thread.sleep(5000)
  }
}

