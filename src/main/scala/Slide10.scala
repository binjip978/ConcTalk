import rx.lang.scala._
import scala.io.Source

object Slide10 {
  def run: Unit = {
    def randomQuote() = Observable.apply[String] { obs =>
      val url = "http://www.iheartquotes.com/api/v1/random?" +
        "show_permalink=false&show_source=false"
      obs.onNext(Source.fromURL(url).getLines.mkString)
      obs.onCompleted()
      Subscription
    }

    import Observable._

    def errorMessage = items("Retrying...") ++ error(new Exception)

    def quoteMessage(): Observable[String] = for {
      text    <- randomQuote()
      message <- if (text.size < 50) items(text) else errorMessage
    } yield message

    quoteMessage().retry(5).subscribe(str => println(str))

    Thread.sleep(5000)
  }
}
