package com.github.markaalvaro.advent2021

fun depthIncreases(fileName: String): Int {
    return FileUtils.readFile(fileName) { it.toInt() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun depthSumIncreases(fileName: String): Int {
    return FileUtils.readFile(fileName) { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { (first, second) -> second > first }
}

fun main() {
    val fileName = "Day01.txt"
    println(depthIncreases(fileName))
    println(depthSumIncreases(fileName))
}