package FP101

object Slide7 {
  def run = {
    trait Option[+A]
    case class Some[+A](v: A) extends Option[A]
    case object None          extends Option[Nothing]

    def unit[A](v: A): Option[A] = {
      Some(v)
    }

    def flatMap[A, B](op: Option[A])(f: A => Option[B]): Option[B] = op match {
      case Some(v) => f(v)
      case None    => None
    }

    def map[A, B](op: Option[A])(f: A => B): Option[B] = {
      flatMap(op)(x => unit(f(x)))
    }
  }
}
