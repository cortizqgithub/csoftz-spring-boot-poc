package com.acme.kt

// https://betterprogramming.pub/how-to-use-generics-in-kotlin-b7f5d8e91e99
class SearchUtil<T>(private val list: List<T>) {
    fun searchItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter {
            it == element
        }
        if (itemFoundList.isNullOrEmpty())
            foundItem(null)
        else
            foundItem(itemFoundList.first())
    }
}

fun search() {
    val searchUtil = SearchUtil(listOf(25, 46, 35))
    searchUtil.searchItem(element = 25) {
        println("Search result : $it")
    }
}

fun search2() {
    val henry = Person2(name = "Henry", email = "henry@email.com", age = 24)
    val robert = Person2(name = "Robert", email = "robert@email.com", age = 22)
    val tom = Person2("Tom", "tom@email.com", 25)

    val listOfPerson = listOf(henry, robert, tom)
    val searchUtil = SearchUtil(listOfPerson)
    searchUtil.searchItem(henry) {
        println("Search result : $it")
    }
}

data class Person2(val name: String, val email: String, val age: Int)


fun main() {
    search()
    search2()
}