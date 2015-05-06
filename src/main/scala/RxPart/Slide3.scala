package RxPart

import rx.lang.scala._

object Slide3 {
  def run: Unit = {
    val ex = new RuntimeException
    val observable: Observable[Int] = Observable.items(0, 1, 2) ++
      Observable.error(ex) ++ Observable.items(3, 4)

    observable.subscribe(
      value => println(value),
      error => println(s"an error occurred: $error")
    )
  }
}
