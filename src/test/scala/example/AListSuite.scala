package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AListSuite extends FunSuite {

  test("List()") {
    assert(List.apply().toString === "")
  }

  test("List(1)") {
    assert(List.apply(1).toString === "1")
  }

  test("List(1, 2)") {
    assert(List.apply(1, 2).toString === "1, 2")
  }
}
