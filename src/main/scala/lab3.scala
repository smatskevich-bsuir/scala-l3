package main.scala
import scala.util.Random

object Lab3 {
    def main(args: Array[String]) {
        val bsuir = new University();
        var inp = ' '

        println("1 - Add student")
        println("2 - Visit university")

        do
        {
            inp = Console.readChar()
            inp match {
                case '1' => {
                    println("Enter student name")
                    val name = Console.readLine()
                    println("Enter student score")
                    val score = Console.readDouble()
                    val id = bsuir.addStudent(name, score)
                    println(s"Added student $name with score = $score, id = $id")
                }
                case '2' => {
                    println("Enter student id")
                    val id = Console.readInt()
                    val res = bsuir.visit(id)
                    println(s"Visited university witd id = $id? $res")
                }
                case 'q' => Nil
                case _ => {
                    println("Bad input. Use:")
                    println("1 - Add student")
                    println("2 - Visit university")
                }
            }
        }
        while(inp != 'q')
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