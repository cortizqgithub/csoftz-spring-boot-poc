package com.acme

import java.util.Locale
import java.util.concurrent.ConcurrentSkipListSet

fun main(args: Array<String>) {
    val hmap: MutableMap<String, String> = HashMap()
    hmap["en"] = "Apple"
    hmap["En"] = "Orange"
    hmap["EN"] = "Kiwi"
    hmap["eN"] = "Banana"
    hmap["null"] = "Banana"
    hmap["Null"] = "Banana"
    hmap["NuLl"] = "Banana"
    hmap["NULL"] = "Banana"
    hmap[" null"] = "empty2"
    hmap["  null  "] = "empty2"
    hmap["pepito"] = "Nice name"
    hmap["   pepito  "] = "Nice name"
    hmap[""] = "empty"
    hmap["           "] = "empty2"
    hmap["es"] = "FRist Espanish"
    val mySet = ConcurrentSkipListSet<String>()
    mySet.add("Null")
    mySet.add("null")
    mySet.add("null")
    mySet.add("nulla")
    println("hmap =>$hmap")
    println("hmap entries => " + hmap.entries)
    println("hmap keys => " + hmap.keys)
    println("hmap values => " + hmap.values)
    println("--------------------------")
    println(mySet)
    countKey("en", hmap)
    countKey("null", hmap)
    countKey("", hmap)
    countKey("es", hmap)
    countKey("ht", hmap)
    countKey("pepito", hmap)
    countKey("pt", hmap)

    val keys = hmap.keys

    println("KEYS -> " + keys)

    val keyFrequencies = keys.stream()
        .map { key -> key.trim { it <= ' ' } }
        .map { key -> key.lowercase(Locale.getDefault()) }
        .toList()
        .groupingBy { it }
        .eachCount()

    println("Key Frequencies="+keyFrequencies)



    val words = "one two three four five six seven eight nine ten".split(' ')
    val frequenciesByFirstChar = words.groupingBy { it.first() }.eachCount()
    println("Counting first letters:")
    println(frequenciesByFirstChar) // {o=1, t=3, f=2, s=2, e=1, n=1}

    val moreWords = "eleven twelve".split(' ')
    val moreFrequencies = moreWords.groupingBy { it.first() }.eachCountTo(frequenciesByFirstChar.toMutableMap())
    println(moreFrequencies) // {o=1, t=4, f=2, s=2, e=2, n=1}
}

private fun countKey(keyValue: String, hmap: Map<String, String>): Boolean {
    val itemCnt = hmap.keys
        .stream()
        .map { key -> key.trim { it <= ' ' } }
        .map { key -> key.lowercase(Locale.getDefault()) }
        .filter { key -> key == keyValue }
        .count()

    println("key used [$keyValue] with $itemCnt times")

    return itemCnt == 0L
}


