import rx.lang.scala._
import scala.concurrent.{Future, blocking}
import scala.concurrent.duration._
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

object Slide9 {
  def run: Unit ={
    def fetchQuote(): Future[String] = Future {
      blocking {
        val url = "http://www.iheartquotes.com/api/v1/random?" +
          "show_permalink=false&show_source=false"
        Source.fromURL(url).getLines().mkString
      }
    }

    def fetchQuoteObservable(): Observable[String] = {
      Observable.from(fetchQuote())
    }

    def quotes(): Observable[Observable[String]] = {
      Observable.interval(1 second).take(5).map {
        n => fetchQuoteObservable().map(txt => s"$n) $txt")
      }
    }

    val concat: Observable[String] = quotes().concat

    concat.subscribe(q => println(q)) // marble diagram
    // concat does not subscribe to subsequent observables
    // so if one take long time => other events are postponed

    val flatten: Observable[String] = quotes().flatten // marble diagram
    // flatten subscribes to subsequent observables
    // so flatten emits values when they arrive

    val qs: Observable[String] = for {
      n   <- Observable.interval(1 second).take(5)
      txt <- fetchQuoteObservable()
    } yield s"$n) $txt"

    // flatMap === flatten . map

    qs.subscribe(q => println(q))

    Thread.sleep(10000)
  }
}
