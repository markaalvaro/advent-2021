package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day01.txt"

fun sonarSweep1(): Int {
    return readFile(FILE_NAME) { it.toInt() }
        .windowed(2)
        .count { (num1, num2) -> num2 > num1 }
}

fun sonarSweep2(): Int {
    return readFile(FILE_NAME) { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { (sum1, sum2) -> sum2 > sum1 }
}

fun main() {
    println(sonarSweep1())
    println(sonarSweep2())
}