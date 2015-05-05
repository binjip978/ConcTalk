import rx.lang.scala._
import Stuff.log

object Slide5 {
  def run: Unit = {
    // def create(f: Observer[T] => Subscription): Observable[T]

    val vms = Observable.apply[String] { obs =>
      obs.onNext("JVM")
      obs.onNext("LLVM")
      obs.onNext("Dalvik")
      obs.onCompleted()
      Subscription
    }

    vms.subscribe(str => log(str))
  }

}
