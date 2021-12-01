package com.github.markaalvaro.advent2021

fun depthIncreases(fileName: String) : Int {
    return  FileUtils.readFile(fileName)
        .map { it.toInt() }
        .windowed(2)
        .count { it[1] > it[0] }
}

fun depthSumIncreases(fileName: String) : Int {
    return  FileUtils.readFile(fileName)
        .asSequence()
        .map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { it[1] > it[0] }
}

fun main() {
    val fileName = "Day01.txt"
    println(depthIncreases(fileName))
    println(depthSumIncreases(fileName))
}