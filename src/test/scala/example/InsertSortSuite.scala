package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InsertSortSuite extends FunSuite{

  test("insertSort(7, 3, 9, 2)") {
    assert(InsertSort.insertSort(scala.List(7, 3, 9, 2)) === scala.List(2, 3, 7, 9))
  }

  test("insert(2, List(2, 3, 9))") {
    assert(InsertSort.insert(7, scala.List(2, 3, 9)) === scala.List(2, 3, 7, 9))
  }
}
