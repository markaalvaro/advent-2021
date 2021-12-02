package com.github.markaalvaro.advent2021

const val DAY_1_FILE_NAME = "Day01.txt"

fun sonarSweep1(fileName: String): Int {
    return readFile(fileName) { it.toInt() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun sonarSweep2(fileName: String): Int {
    return readFile(fileName) { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun main() {
    println(sonarSweep1(DAY_1_FILE_NAME))
    println(sonarSweep2(DAY_1_FILE_NAME))
}