package example

abstract class Boolean {

  def ifThenElse(theN: Boolean, elsE: Boolean): Boolean
  def &&(other: Boolean): Boolean = ifThenElse(other, False)
  def ||(other: Boolean): Boolean = ifThenElse(True, other)
  def unary_! = ifThenElse(False, True)
  def ==(other: Boolean) = ifThenElse(other, !other)
  def !=(other: Boolean) = ifThenElse(!other, other)
  def <(other: Boolean) = ifThenElse(False, other)
  def >(other: Boolean) = ifThenElse(!other, False)
}

object True extends Boolean {
  override def ifThenElse(theN: Boolean, elsE: Boolean): Boolean = theN
}

object False extends Boolean {
  override def ifThenElse(theN: Boolean, elsE: Boolean): Boolean = elsE
}
