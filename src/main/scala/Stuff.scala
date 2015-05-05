object Stuff {
  def log[T](x: T): Unit = {
    println(Thread.currentThread().getName + s" $x")
  }
}
