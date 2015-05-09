package FP101

import scala.util.{Try, Success, Failure}

object Slide6 {
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

    val book = withdrawMoney("user1", "password2", 100)
      .flatMap(cash => buyBook("Functional Programming in Scala", cash))

    book.foreach(b => println(b))
  }
}
