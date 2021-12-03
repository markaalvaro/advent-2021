package com.github.markaalvaro.advent2021

import java.util.stream.Collectors

const val DAY3_FILE_NAME = "Day03.txt"

fun part1() : Int {
    val counts = mutableMapOf<Int, Int>()
    readFile(DAY3_FILE_NAME)
        .map { it.toList() }
        .forEach { list ->
            list.forEachIndexed { index, s ->
                val toAdd = if (s == '1') 1 else 0
                counts[index] = (counts[index] ?: 0) + toAdd
            }
        }

    val a = counts.values.map { it > 500 }.joinToString("") { if (it) "1" else "0" }
    val b = counts.values.map { it < 500 }.joinToString("") { if (it) "1" else "0" }

    return Integer.parseInt(a, 2) * Integer.parseInt(b, 2)
}

fun part2() : Int {
    var oxygen = readFile(DAY3_FILE_NAME)
    var cO2 = readFile(DAY3_FILE_NAME)

    for (i in 0..11) {
        if (oxygen.size > 1) {
            val mostCommonOxygen = find(i, oxygen)
            oxygen = oxygen.filter { it[i] == mostCommonOxygen }
        }

        if (cO2.size > 1) {
            val mostCommonCO2 = find(i, cO2)
            cO2 = cO2.filter { it[i] != mostCommonCO2 }
        }
    }

    return Integer.parseInt(oxygen[0], 2) * Integer.parseInt(cO2[0], 2)
}

fun find(index: Int, lines: List<String>) : Char {
    val count1 = lines.count { it[index] == '1' }
    val count0 = lines.count { it[index] == '0' }

    return if (count1 >= count0) '1' else '0'
}

fun main() {
    println(part1())
    println(part2())
}