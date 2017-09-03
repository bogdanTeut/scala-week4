package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSuite extends FunSuite{

  trait Nats {
    val zero = Zero
    val one = Zero.successor
    val two = Zero.successor.successor
    val three = Zero.successor.successor.successor
    val four = Zero.successor.successor.successor.successor
    val five = Zero.successor.successor.successor.successor.successor
  }

  test("isZero") {
    new Nats {
      assert(zero.isZero)
      assert(!one.isZero)
    }
  }

  test("predecessor") {
    new Nats {
      intercept[NoSuchElementException] {
        zero.predecessor
      }
      assert(one.predecessor === zero)
    }
  }

  test("eq") {
    new Nats {
      assert(zero.successor == one)
      assert(two == new Succ(new Succ(Zero)))
      assert(zero.successor != Zero)
      assert(!zero.eq(zero.successor))
    }
  }

  test("successor") {
    new Nats {
      assert(zero.successor == zero.successor)
      assert(two == Zero.successor.successor)
    }
  }

  test("-") {
    new Nats {
      intercept[NoSuchElementException] {
        zero - one
      }
      assert(two - two === zero)
      assert(three - three === zero)
      assert(three - one === two)
    }
  }

  test("+") {
    new Nats {
      assert (zero + one == one)
      assert(three + two === five)
    }
  }
}
