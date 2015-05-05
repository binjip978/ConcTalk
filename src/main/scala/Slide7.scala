import rx.lang.scala._
import org.apache.commons.io.monitor._

object Slide7 {
  def run: Unit = {
    def coldObserver(directory: String): Observable[String] = {
      //In Rx, Observable objects that only emit events only when
      //subscriptions exist are called cold observables

      // Otherwise observable is called hot

      Observable.apply[String] { obs =>
        val fileMonitor  = new FileAlterationMonitor(1000)
        val fileObs      = new FileAlterationObserver(directory)
        val fileListener = new FileAlterationListenerAdaptor {
          override def onFileChange(file: java.io.File): Unit = {
            obs.onNext(file.getName)
          }
        }
        fileObs.addListener(fileListener)
        fileMonitor.addObserver(fileObs)
        fileMonitor.start()
        Subscription {
          fileMonitor.stop()
        }
      }
    }

    def hotObserver(directory: String): Observable[String] = {
      val fileMonitor  = new FileAlterationMonitor(1000)
      val fileObs      = new FileAlterationObserver(directory)
      fileMonitor.addObserver(fileObs)

      Observable.apply[String] { obs =>
        val fileListener = new FileAlterationListenerAdaptor {
          override def onFileChange(file: java.io.File): Unit = {
            obs.onNext(file.getName)
          }
        }
        fileObs.addListener(fileListener)
        Subscription { fileObs.removeListener(fileListener) }
      }
    }

    println("Started monitor files")
    val sub = coldObserver("/home/ssementchouk/my_work").subscribe(str => println(s"File changed: $str"))
    Thread.sleep(10000)
    sub.unsubscribe()
  }
}
