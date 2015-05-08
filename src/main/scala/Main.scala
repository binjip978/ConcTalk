object Main extends App {
  FP101.Slide4.run

  // every Observable[T] object can be in 3 state:
  //   uncompleted (he can emit value of type T)
  //   error (when he produce an exception, and cannot emit new events)
  //   completed
}
