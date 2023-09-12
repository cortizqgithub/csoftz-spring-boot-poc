package com.acme.kt.common.functions

fun add(a: Int, b: Int) = a + b
fun subtract(a: Int, b: Int) = a - b

val calc = mutableListOf(::add, ::subtract)
val adding:(Int,Int)-> Int = ::add

fun main() {
    println(calc[0](1, 2))
    println(calc[1](1, 2))
    println(adding(3, 5))
}

