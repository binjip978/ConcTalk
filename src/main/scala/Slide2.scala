import rx.lang.scala._
import scala.concurrent.duration._
import Stuff.log

object Slide2 {
  def run: Unit = {
    val o: Observable[Long] = Observable.timer(2 second)
    o.subscribe(x => log(x))
    o.subscribe(x => log(x + 1000))

    Thread.sleep(5000)
  }
}
