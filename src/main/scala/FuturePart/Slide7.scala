package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide7 {
  def run: Unit = {
    def getUSDQuote = Future { 1.2 }
    def getEURQuote = Future { 0.8 }

    val p = for {
      usd <- getUSDQuote
      eur <- getEURQuote
      if (eur > usd)
    } yield usd

    p onFailure { case (e) => println("Error: " + e) }

    Thread.sleep(1000)
  }
}
