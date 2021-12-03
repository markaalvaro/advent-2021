package com.github.markaalvaro.advent2021

const val DAY3_FILE_NAME = "Day03.txt"

fun binaryDiagnostic1() : Int {
    val counts = mutableMapOf<Int, Int>()
    readFile(DAY3_FILE_NAME)
        .map { it.toList() }
        .forEach { list ->
            list.forEachIndexed { index, s ->
                val toAdd = if (s == '1') 1 else 0
                counts[index] = (counts[index] ?: 0) + toAdd
            }
        }

    val gamma = counts.values.map { it > 500 }.joinToString("") { if (it) "1" else "0" }
    val epsilon = gamma.toList().map { if (it == '1') '0' else '1' }.joinToString("")

    return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
}

fun binaryDiagnostic2() : Int {
    var oxygen = readFile(DAY3_FILE_NAME)
    var cO2 = oxygen.toList()

    var i = 0
    while (oxygen.size > 1 || cO2.size > 1) {
        if (oxygen.size > 1) {
            val mostCommonOxygen = findMostCommonBit(i, oxygen)
            oxygen = oxygen.filter { it[i] == mostCommonOxygen }
        }

        if (cO2.size > 1) {
            val mostCommonCO2 = findMostCommonBit(i, cO2)
            cO2 = cO2.filter { it[i] != mostCommonCO2 }
        }

        i++
    }

    return Integer.parseInt(oxygen[0], 2) * Integer.parseInt(cO2[0], 2)
}

fun findMostCommonBit(index: Int, lines: List<String>) : Char {
    val count1 = lines.count { it[index] == '1' }
    return if (count1 >= lines.size - count1) '1' else '0'
}

fun main() {
    println(binaryDiagnostic1())
    println(binaryDiagnostic2())
}