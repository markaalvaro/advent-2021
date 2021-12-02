package com.github.markaalvaro.advent2021

const val DAY_2_FILE_NAME = "Day02.txt"

fun dive1(fileName: String): Int {
    var depth = 0
    var horizontal = 0

    readFile(fileName) { it.split(" ") }
        .forEach { (direction, value) ->
            value.toInt().also {
                when (direction) {
                    "forward" -> horizontal += it
                    "down" -> depth += it
                    "up" -> depth -= it
                }
            }
        }

    return depth * horizontal
}

fun dive2(fileName: String): Int {
    var depth = 0
    var horizontal = 0
    var aim = 0

    readFile(fileName) { it.split(" ") }
        .forEach { (direction, value) ->
            value.toInt().also {
                when (direction) {
                    "forward" -> {
                        horizontal += it; depth += aim * it
                    }
                    "down" -> aim += it
                    "up" -> aim -= it
                }
            }
        }

    return depth * horizontal
}

fun main() {
    println(dive1(DAY_2_FILE_NAME))
    println(dive2(DAY_2_FILE_NAME))
}