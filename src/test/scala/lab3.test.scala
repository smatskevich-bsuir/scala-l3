import main.scala.University
import org.scalatest._
import scala.util.Random

class Lab3Tests extends FunSuite {
    test("university add student") {
        val uni = new University()
        assert(uni.addStudent("Name", 10).isInstanceOf[Int])
    }

    test("university visit") {
        val uni = new University()
        assert(uni.visit(uni.addStudent("Name", 10)))
    }

    test("university visit random") {
        val uni = new University()
        uni.addStudent("Name", 10)
        assert(!uni.visit(new Random().nextInt()))
    }
}