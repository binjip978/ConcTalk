package FP101

import scala.util.{Try, Success, Failure}

object Slide4 {
  def run: Unit = {
    case class Money(amount: Int)
    case class Book(title: String)

    def withdrawMoney(user: String, password: String, amount: Int): Try[Money] = {
      // some logic
      Try(Money(amount))
    }

    def buyBook(name: String, cash: Money): Try[Book] = {
      // some logic
      Try(Book("Functional Programming in Scala"))
    }

    withdrawMoney("user1", "password2", 100) match {
      case Success(cash) => {
        buyBook("Functional Programming in Scala", cash) match {
          case Success(book) => println("book")
          case Failure(e)    => println(s"Error occurred: $e")
        }
      }
      case Failure(e)    => println(s"Error occurred: $e")
    }
  }
}
