package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

 @RunWith(classOf[JUnitRunner])
class BooleanSuite extends FunSuite {

   test("&&") {
     assert((True && True) === True)
     assert((True && False) === False)
     assert((False && True) === False)
     assert((False && False) === False)
   }

   test("||") {
     assert((True || True) === True)
     assert((True || False) === True)
     assert((False || True) === True)
     assert((False || False) === False)
   }

   test("!") {
     assert(!True === False)
     assert(!False === True)
   }

   test("==") {
     assert( (True == True) === True)
     assert( (True == False) === False)
     assert( (False == False) === True)
     assert( (False == True) === False)
   }

   test("!=") {
     assert( (True != True) === False)
     assert( (True != False) === True)
     assert( (False != False) === False)
     assert( (False != True) === True)

   }

   test("<") {
     assert((False < True) === True);
     assert((False < False) === False);
     assert((True < False) === False);
     assert((True < True) === False);
   }

   test(">") {
     assert((False > True) === False);
     assert((False > False) === False);
     assert((True > False) === True);
     assert((True > True) === False);
   }
}
