package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day03.txt"

val String.binaryToInt: Int
    get() { return Integer.parseInt(this, 2) }

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

    return gamma.binaryToInt * epsilon.binaryToInt
}

fun binaryDiagnostic2(): Int {
    var o2 = readFile(FILE_NAME)
    var cO2 = o2.toList()

    var i = 0
    while (o2.size > 1 || cO2.size > 1) {
        if (o2.size > 1) {
            val mostCommon = o2.mostCommonBit(i)
            o2 = o2.filter { it[i] == mostCommon }
        }

        if (cO2.size > 1) {
            val mostCommon = cO2.mostCommonBit(i)
            cO2 = cO2.filter { it[i] != mostCommon }
        }

        i++
    }

    return o2[0].binaryToInt * cO2[0].binaryToInt
}

fun main() {
    println(binaryDiagnostic1())
    println(binaryDiagnostic2())
}