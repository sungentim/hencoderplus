package com.example.app

import android.content.res.Resources
import android.util.TypedValue
import java.lang.StringBuilder
import java.util.*

/**
 * 类描述：
 * @author sungen
 * @date 2020/5/25 10:18 AM
 **/
sealed class Reulst

data class Success(var name: String) : Reulst()

data class Fail(var name: String) : Reulst()

fun String.letter(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

fun Float.dp(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
}

fun Int.dp(): Float {
    return this.toFloat().dp()
}

fun main() {
    print("tim".letter())
//    val listFruit = listOf("apple", "banana", "orange", "pear", "grape")
//    val result = with(StringBuilder()) {
//        append("start eating fruits\n")
//        for (fruit in listFruit) {
//            append(fruit + "\n")
//        }
//        append("eating all fruit\n")
//        toString()
//    }
//    println(result)
//    handleResult(Success("name"))
//    for (fruit in listFruit) {
//        println(fruit)
//    }
//    val mapFruit = mapOf("apple" to 1, "banana" to 2)
//    for ((fruit, number) in mapFruit) {
//        println("$number is $fruit")
//    }
//    println(listFruit.filter { it.length < 5 }.map { it.toUpperCase(Locale.ROOT) })
//    print(getTextLength(null))
}

fun handleResult(result: Reulst) {
    when (result) {
        is Success -> println("$result.name")
        is Fail -> println("Fail")
    }
}

fun getTextLength(text: String?) = text?.length ?: 0

fun forTest() {
    for (i in 10 downTo 0 step 1) {
        println(i)
    }
}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomework()
}

data class Tim(val name: String, val age: Int)
open class Person(val name: String, val age: Int)

class Student(val sno: Int, name: String, age: Int) : Person(name, age), Study {
    constructor(sno: Int) : this(sno, "", 0)

    override fun readBooks() {
        println("$name is readBooks")
    }

//    override fun doHomework() {
//        println("${name} is doHomework")
//    }

}

class Student1 : Person {
    constructor(name: String, age: Int) : super(name, age) {

    }
}

interface Study {
    fun readBooks()
    fun doHomework() {
        println("study interface")
    }
}

//单例
object Single {
    fun test() {
        println("Test")
    }
}