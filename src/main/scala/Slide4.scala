import rx.lang.scala._
import Stuff.log

object Slide4 {
  def run: Unit = {
    val countries = List("Germany", "US", "Japan")
    val observable = Observable.from(countries)

    observable.subscribe(new Observer[String] {
      override def onNext(c: String) = log(s"Nice to live in $c")
      override def onError(e: Throwable) = log("error!!!")
      override def onCompleted() = log("That all list!")
    })
  }
}
