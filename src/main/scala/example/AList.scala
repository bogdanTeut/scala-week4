package example

trait List[+T] {
  def isEmpty: scala.Boolean
  def head: T
  def tail: List[T]
  def prepend[S >: T](elem: S): List[S] = new Cons(elem, Nil)
}

object Nil extends List[Nothing] {
  override def isEmpty: scala.Boolean = true
  override def toString: String = ""
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing  = throw new NoSuchElementException
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: scala.Boolean = false
  override def toString: String = head + appendComma + tail.toString
  def appendComma = if(!tail.isEmpty) ", " else ""
}

object List {
  def apply(): List[Int] = Nil
  def apply(x: Int): List[Int] = new Cons(x, Nil)
  def apply(x: Int, y: Int): List[Int] = new Cons(x, List.apply(y))
}
