import rx.lang.scala._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

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
