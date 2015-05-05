import rx.lang.scala._


object Slide11 {
  def run: Unit = {
    val status = Observable.items("1", "2") ++ Observable.error(new Exception)
    val fixedStatus = status.onErrorReturn(e => "exception")

    fixedStatus.subscribe(str => println(str))

    val continuedStatus = status.onErrorResumeNext(e => Observable.items("4", "5"))

    continuedStatus.subscribe(str => println(str))
  }
}
