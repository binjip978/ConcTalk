package FP101

import scala.util.{Try, Success, Failure}

object Slide5 {
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

    for {
      cash <- withdrawMoney("user1", "password2", 100)
      book <- buyBook("Functional Programming in Scala", cash)
    } println(book)
  }
}
