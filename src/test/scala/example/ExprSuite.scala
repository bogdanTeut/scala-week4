package example

import example.Expression.{evaluate2, show2}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExprSuite extends FunSuite {

  trait Numbers {
    val one = Number(1)
    val two = Number(2)
    val three = Number(3)
    val four = Number(4)
    val five = Number(5)
  }

  test("number") {
    new Numbers {
      assert(five.evaluate === 5)
      assert(evaluate2(five) === 5)
      assert(five.evaluate3 === 5)
      assert(five.show === "5")
      assert(show2(five) === "5")
      assert(five.show3 === "5")
    }
  }

  test("sum") {
    new Numbers {
      //evaluate
      assert(new Sum(new Number(1), two).evaluate === 3)
      assert(evaluate2(new Sum(one, two)) === 3)
      assert(new Sum(one, two).evaluate3 === 3)

      //show
      assert(new Sum(one, two).show === "1 + 2")
      assert(show2(new Sum(one, two)) === "1 + 2")
      assert(new Sum(one, two).show3 === "1 + 2")

      //complex evaluate
      assert(new Sum(new Sum(one, three), two).evaluate === 6)
      assert(evaluate2(new Sum(new Sum(one, three), two)) === 6)
      assert(new Sum(new Sum(one, three), two).evaluate3 === 6)

      //complex show
      assert(new Sum(new Sum(one, three), two).show === "1 + 3 + 2")
      assert(show2(new Sum(new Sum(one, three), two)) === "1 + 3 + 2")
      assert(new Sum(new Sum(one, three), two).show3 === "1 + 3 + 2")
    }
  }

  test("var") {
    intercept[UnsupportedOperationException] {
      new Var("x").evaluate
    }
    intercept[UnsupportedOperationException] {
      evaluate2(new Var("x"))
    }
    intercept[UnsupportedOperationException] {
      new Var("x").evaluate3
    }
    assert(new Var("x").show === "x")
    assert(show2(new Var("x")) === "x")
    assert(new Var("x").show3 === "x")
  }

  test("prod") {
    new Numbers {
      assert(new Prod(two, three).evaluate === 6)
      assert(evaluate2(new Prod(two, three)) === 6)
      assert(new Prod(two, three).evaluate3 === 6)

      assert(new Prod(two, three).show === "2 * 3")
      assert(show2(new Prod(two, three)) === "2 * 3")
      assert(new Prod(two, three).show3 === "2 * 3")

      assert(new Prod(new Prod(two, two), three).evaluate === 12)
      assert(evaluate2(new Prod(new Prod(two, two), three)) === 12)
      assert(new Prod(new Prod(two, two), three).evaluate3 === 12)

      assert(new Prod(new Prod(two, two), three).show === "2 * 2 * 3")
      assert(show2(new Prod(new Prod(two, two), three)) === "2 * 2 * 3")
      assert(new Prod(new Prod(two, two), three).show3 === "2 * 2 * 3")
    }
  }

  test("complex expression") {
    new Numbers {
      assert(new Prod(new Sum(one, two), three).show3 === "(1 + 2) * 3")
    }
  }
}
