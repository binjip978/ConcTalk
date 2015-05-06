package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide2 {
  def run: Unit ={
    def getUrlSpec(): Future[List[String]] = Future {
      val url = "http://www.w3.org/Addressing/URL/url-spec.txt"
      val f = scala.io.Source.fromURL(url)
      try {
        f.getLines().toList
      } finally {
        f.close()
      }
    }

    def find(lines: List[String], keyword: String): String = {
      lines.zipWithIndex.collect {
        case (line, n) if (line.contains(keyword)) => (n, line)
      } mkString("\n")
    }

    val f = getUrlSpec()

    f.foreach {
      case (lines) => println(find(lines, "telnet"))
    }

    Thread.sleep(5000)
  }



}
