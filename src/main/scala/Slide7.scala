import rx.lang.scala._
import org.apache.commons.io.monitor._

object Slide7 {
  def run: Unit = {
    def modified(directory: String): Observable[String] = {
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
  }

}
