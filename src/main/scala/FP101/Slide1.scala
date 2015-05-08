package FP101

object Slide1 {
  def run = {
    case class Money(amount: Int)
    case class Book(title: String)

    def withdrawMoney(user: String, password: String, amount: Int): Money = {
      // some logic
      Money(amount)
    }

    def buyBook(name: String, cash: Money): Book = {
      // some logic
      Book("Functional Programming in Scala")
    }

    val cash = withdrawMoney("user1", "password2", 100)
    val book = buyBook("Functional Programming in Scala", cash)

    println(book)
  }

}
