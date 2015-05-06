package RxPart

import rx.lang.scala._

object Slide4 {
  def run: Unit = {
    val countries = List("Germany", "US", "Japan")
    val observable = Observable.from(countries)

    observable.subscribe(new Observer[String] {
      override def onNext(c: String) = println(s"Nice to live in $c")
      override def onError(e: Throwable) = println("error!!!")
      override def onCompleted() = println("That all list!")
    })
  }
}
