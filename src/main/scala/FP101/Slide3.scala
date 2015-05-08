package FP101

import scala.util.{Try, Success, Failure}

object Slide3 {
  def run: Unit ={
    val v = Try {
      if (scala.util.Random.nextBoolean() == true) 12
      else 1 / 0
    }

    v match {
      case Success(v) => println(v)
      case Failure(e) => println("Error!")
    }
  }
}
