package RxPart

import rx.lang.scala._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.{Failure, Success}

object Slide6 {
  def run {
    val f = Future("Future")

    val observable = Observable.apply[String] { obs =>
      f onComplete {
        case Success(v) => {
          obs.onNext(v)
          obs.onCompleted()
        }
        case Failure(e) => {
          obs.onError(e)
        }
      }

      Subscription
    }

    observable.subscribe(str => println(str))
    Thread.sleep(2000)
  }
}
