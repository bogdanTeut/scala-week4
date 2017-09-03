package example

trait Expr {
  def evaluate(): Int
  def show(): String
  def evaluate3(): Int = this match {
      case Number(n) => n
      case Sum(leftOp, rightOp) => leftOp.evaluate3() + rightOp.evaluate3()
      case Var(_) => throw new UnsupportedOperationException("eval for var")
      case Prod(leftOp, rightOp) => leftOp.evaluate3() * rightOp.evaluate3()
      case _ => throw new NoSuchElementException("Expression unknown")
    }

  def show3(): String = this match {
    case Number(n) => n.toString
    case Sum(leftOp, rightOp) => leftOp.show3() + " + " + rightOp.show3()
    case Var(x) => x
    case Prod(Sum(leftSumOp, rightSumOp), rightOp) => "(" + leftSumOp.show3() + " + " + rightSumOp.show3() + ")" +
                                                      " * " + rightOp.show3()
    case Prod(leftOp, rightOp) => leftOp.show3() + " * " + rightOp.show3()
    case _ => throw new NoSuchElementException("Expression unknown")
  }
}

case class Number(n: Int) extends Expr {
  def number: Int = n
  def evaluate(): Int = n
  def show: String = number.toString
}

case class Sum(op1: Expr, op2: Expr) extends Expr {
  def leftOp = op1
  def rightOp = op2
  def evaluate(): Int = leftOp.evaluate() + rightOp.evaluate()
  def show: String = leftOp.show + " + " + rightOp.show
}

case class Var(n: String) extends Expr {
  def name: String = n
  def evaluate(): Int = throw new UnsupportedOperationException("eval for var")
  def show: String = n
}

case class Prod(op1: Expr, op2: Expr) extends Expr {
  def leftOp = op1
  def rightOp = op2
  def evaluate(): Int = leftOp.evaluate() * rightOp.evaluate()
  def show: String = leftOp.show + " * " +rightOp.show
}

object Expression {
  def evaluate2(expr: Expr): Int =
    expr match {
      case expr: Number => expr.number
      case expr: Sum => evaluate2(expr.leftOp) + evaluate2(expr.rightOp)
      case _: Var => throw new UnsupportedOperationException("eval for var")
      case expr: Prod => evaluate2(expr.leftOp) * evaluate2(expr.rightOp)
      case _ => throw new NoSuchElementException("Expression unknown")
    }

  def show2(expr: Expr): String =
    expr match {
      case expr: Number => expr.number.toString
      case expr: Sum => show2(expr.leftOp) + " + " + show2(expr.rightOp)
      case expr: Var => expr.name
      case expr: Prod => show2(expr.leftOp) + " * " + show2(expr.rightOp)
      case _ => throw new NoSuchElementException("Expression unknown")
    }
}
