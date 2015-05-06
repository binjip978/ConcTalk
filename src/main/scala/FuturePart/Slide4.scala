package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide4 {
  def run: Unit ={
    val f1: Future[Int] = Future { 1345 }
    val f2: Future[Int] = Future { 2356 }
    val f3: Future[Int] = Future { 4563 }

    val comp1: Future[Int] = f1.flatMap(v1 => f2.flatMap(v2 => f3.map(v3 => v1 + v2 + v3)))

    val comp2: Future[Int] = for {
      v1 <- f1
      v2 <- f2
      v3 <- f3
    } yield v1 + v2 + v3

    //comp1 === comp2

    comp1.onSuccess { case(x: Int) => println(x) }
    comp2.onSuccess { case(x: Int) => println(x) }

    Thread.sleep(1000)
  }
}
