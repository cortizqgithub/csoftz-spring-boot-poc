package com.acme.kt

import com.acme.kt.common.extensions.size
import com.acme.kt.common.extensions.square

fun main(args: Array<String>) {
    println("Hello World!")
    println("House".size)
    println("10 * 10 = ${10.square()}")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    println("Person is : " + Person("Ferdinand", 15))
    println("Another Person: " + Person())

    val p = Person()
    //p.age = 21
    //p.name = "Charlie"
    println("Person modified $p")
}