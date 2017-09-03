package example

abstract class Nat {
  def isZero: scala.Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def -(that: Nat): Nat
  def +(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: scala.Boolean = true
  override def predecessor: Nat = throw new NoSuchElementException("Zero predecessor")
  override def -(that: Nat) = if (that.isZero) this else throw new NoSuchElementException("Zero -")
  override def +(that: Nat) = that
}

class Succ(pred: Nat) extends Nat {
  override def isZero: scala.Boolean = false
  def predecessor: Nat = pred
  override def -(that: Nat) = if(that isZero) this else this.predecessor - that.predecessor
  override def +(that: Nat): Nat = new Succ(this.predecessor + that)

  override def equals(that: scala.Any): scala.Boolean =
    that match {
      case that: Succ => this - that == Zero
      case _ => false
    }
}
