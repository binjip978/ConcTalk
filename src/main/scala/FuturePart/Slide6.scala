package FuturePart

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Slide6 {
  def run: Unit = {
    def getRandonName             = Future { "John" }
    def getIdByName(name: String) = Future { 12 }
    def getDepotIdById(id: Int)   = Future { 34 }
    def getDepotName(id: Int)     = Future { "A depot" }

    val f = for {
      name      <- getRandonName
      userId    <- getIdByName(name)
      depotId   <- getDepotIdById(userId)
      depotName <- getDepotName(userId)
    } yield s"$name from $depotName"

    f.onSuccess {
      case (v) => println(v)
    }

    Thread.sleep(1000)
  }
}
