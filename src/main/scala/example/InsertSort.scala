package example

object InsertSort {

  def insert(x: Int, xs: scala.List[Int]): scala.List[Int] = xs match {
    case scala.List() => scala.List(x)
    case y::ys => if (x < y) x::xs else y::insert(x, ys)
  }

  def insertSort(xs :scala.List[Int]): scala.List[Int] = xs match {
    case scala.List() => scala.List()
    case y::ys => insert(y, insertSort(ys))
  }
}
