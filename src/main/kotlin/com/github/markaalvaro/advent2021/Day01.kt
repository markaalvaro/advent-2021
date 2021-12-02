package com.github.markaalvaro.advent2021

const val DAY_1_FILE_NAME = "Day01.txt"

fun depthIncreases(fileName: String): Int {
    return readFile(fileName) { it.toInt() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun depthSumIncreases(fileName: String): Int {
    return readFile(fileName) { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun main() {
    println(depthIncreases(DAY_1_FILE_NAME))
    println(depthSumIncreases(DAY_1_FILE_NAME))
}