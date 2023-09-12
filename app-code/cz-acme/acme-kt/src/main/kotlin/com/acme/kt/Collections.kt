package com.acme.kt

fun useFlatten() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
}

fun useToMap() {
    val user1 = User("John", 18, listOf("Hiking"))
    val user2 = User("Sara", 25, listOf("Chess"))
    val user3 = User("Dave", 34, listOf("Games"))

    val myList = listOf(user1, user2, user3)
    val myMap = myList.map { it.name to it.age}

    println(myMap)
}

data class User(val name: String, val age: Int, val hobbies: List<String>)

fun main() {
    useToMap()
}

