package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day03.txt"

fun String.binaryToInt(): Int {
    return Integer.parseInt(this, 2)
}

fun List<String>.mostCommonBit(index: Int): Char {
    val count1 = this.count { it[index] == '1' }
    return if (count1 >= this.size - count1) '1' else '0'
}

fun binaryDiagnostic1(): Int {
    val gamma = readFile(FILE_NAME)
        .asSequence()
        .flatMap { it.toList().withIndex() }
        .groupBy { it.index }
        .map {
            it.value
                .map { indexedValue -> indexedValue.value }
                .groupingBy { digit -> digit }
                .eachCount()
                .maxByOrNull { count -> count.value }
                ?.key
        }
        .joinToString("")

    val epsilon = gamma.toList().map { if (it == '1') '0' else '1' }.joinToString("")

    return gamma.binaryToInt() * epsilon.binaryToInt()
}

fun binaryDiagnostic2(): Int {
    var oxygen = readFile(FILE_NAME)
    var cO2 = oxygen.toList()

    var i = 0
    while (oxygen.size > 1 || cO2.size > 1) {
        if (oxygen.size > 1) {
            val mostCommonOxygen = oxygen.mostCommonBit(i)
            oxygen = oxygen.filter { it[i] == mostCommonOxygen }
        }

        if (cO2.size > 1) {
            val mostCommonCO2 = cO2.mostCommonBit(i)
            cO2 = cO2.filter { it[i] != mostCommonCO2 }
        }

        i++
    }

    return oxygen[0].binaryToInt() * cO2[0].binaryToInt()
}

fun main() {
    println(binaryDiagnostic1())
    println(binaryDiagnostic2())
}