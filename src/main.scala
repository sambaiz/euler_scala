object Main {
  def main(args: Array[String]) = {
    //println("sum 1 to 100 is " + util.sumIfTrue(1,(n:Int) => n<=100))
    Problem1.answer
    Problem2.answer
  }
}

package object impl {
  implicit def booleanToInt(bool: Boolean): Int = if (bool) 1 else 0 
}

package object util {
  import impl._
  def sumIfTrue(num: Int, 
      nonstop: (Int) => Boolean, //Œp‘±‚·‚éðŒŽ®
      expr: (Int) => Boolean = (n:Int) => true, //‰ÁŽZ‚·‚éðŒŽ®
      next: (Int) => Int = (n: Int) => n+1): Int = //ŽŸ‚Ì’l‚Ì“ü—Í
    if(nonstop(num)) 
      expr(num) * num + sumIfTrue(next(num), nonstop, expr, next)
      else 0
}

//Project Euler

object Problem1 {
  import impl._
  def answer() = println("Problem1 answer is " +
    util.sumIfTrue(1, (n) => n<=1000-1, (n) => n % 3 == 0 || n % 5 == 0));
}

object Problem2 {
  val fibonacci = () => { //ƒNƒ[ƒWƒƒ
    var num = 1
    var beforenum = 1
    (n:Int) => { //n:dammy
      val ret = num + beforenum
      beforenum = num
      num = ret
      ret
    }
  }
  def answer() = println("Problem2 answer is " +
    util.sumIfTrue(1, (n) => n<=4000000-1, (n: Int) => n % 2 == 0, 
        fibonacci()))
}