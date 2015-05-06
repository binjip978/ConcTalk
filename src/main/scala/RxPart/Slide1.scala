package RxPart

import rx.lang.scala._

object Slide1 {
  def run(): Unit = {
    val observable: Observable[String] = Observable.items("A", "B", "C")

    observable.subscribe(str => println(str.toLowerCase))
    observable.subscribe(str => println(str * 7))

    // this is sync behavior, because Observable has all his object
    // on creation time
  }

}
