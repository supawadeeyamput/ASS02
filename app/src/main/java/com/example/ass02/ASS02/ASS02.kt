package com.example.ass02.ASS02

data class subject(val id: String, val name: String, val credit: Int)

open class person(fName:String,lName:String,dName:String){
    val firstName : String
    val lastName : String
    val deptName : String
    init {
        firstName = fName.capitalize();
        lastName = lName.capitalize();
        deptName = dName.capitalize();
    }

    open fun showDetail(){
        println("$firstName is a student in $deptName")
    }
}

class student(fName: String,lName: String,dName: String):person(fName,lName,dName){
    private var creditClass : Int =0
    private var gradeValue : Float = 0.0F

    override fun showDetail() {
        println("$firstName is a student in $deptName, Faculty of Science")
    }

    fun gradeEnroll(subj: subject, point: Float){
        var grade : String
        var gpa : Float = 0.0f
        when{
            point <50 -> { grade = "F"
                gpa = 0.0f }
            point <55 -> { grade = "D"
                gpa = 1.0f }
            point <60 -> { grade = "D+"
                gpa = 1.5f }
            point <65 -> { grade = "C"
                gpa = 2.0f }
            point <70 -> { grade = "C+"
                gpa = 2.5f }
            point <75 -> { grade = "B"
                gpa = 3.0f }
            point <80 -> { grade = "B+"
                gpa = 3.5f }
            else -> { grade = "A"
                gpa = 4.0f }
        }
        println(subj.toString()+"Score : $point, Grade : $grade")
        gradeValue += gpa*subj.credit
        creditClass += subj.credit
    }
    fun displayGpa(){
        var gpax: Float = gradeValue/creditClass
        println("$firstName 's GPA is ${String.format("%.2f", gpax)}")
    }
}

fun main(){
    var subject1 = subject("342267", "Mobile Device Programming", 3)
    var subject2 = subject("342233", "Database Systems and Design", 3)
    var subject3 = subject("342233", "Seminar in Information technology", 1)
    var person3 = student("Goofy", "Funny", "Information Technology")
    println("Member NO 5 : ${person3.firstName} ${person3.lastName}")
    person3.showDetail()
    person3.gradeEnroll(subject1, 74f)
    person3.gradeEnroll(subject2, 89f)
    person3.gradeEnroll(subject3, 57f)
    person3.displayGpa()
}

