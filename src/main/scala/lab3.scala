package main.scala
import scala.util.Random

object Lab3 {
    def main(args: Array[String]) {
        val bsuir = new University();
        val ivan = bsuir.addStudent("Ivan", 6)
        val petr = bsuir.addStudent("Petr", 7)
        
        println(s"Ivan id is $ivan")
        println(s"Petr id is $petr")

        println("Ivan visited university?")
        println(bsuir.visit(ivan))

        println("Petr visited university?")
        println(bsuir.visit(petr))

        println("Random visited university?")
        println(bsuir.visit(new Random().nextInt()))
    }
}

class University()
{
    private var baseID = 8505000
    private var students = List[Student]()
    
    def addStudent(name: String, score: Double): Int = {
        baseID += 1
        students ::= new Student(name, score, baseID)
        baseID
    }

    def visit(id: Int): Boolean = {
        students.find((student) => { student.id == id}).isDefined
    }
}
class Student(var name: String, var score: Double, var id: Int)