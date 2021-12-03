package com.github.markaalvaro.advent2021

const val DAY2_FILE_NAME = "Day02.txt"

fun dive1(): Int {
    var depth = 0
    var horizontal = 0

    readFile(DAY2_FILE_NAME) { it.split(" ") }
        .map { (direction, value) -> Pair(direction, value.toInt()) }
        .forEach { (direction, value) ->
            when (direction) {
                "forward" -> horizontal += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

    return depth * horizontal
}

fun dive2(): Int {
    var depth = 0
    var horizontal = 0
    var aim = 0

    readFile(DAY2_FILE_NAME) { it.split(" ") }
        .map { (direction, value) -> Pair(direction, value.toInt()) }
        .forEach { (direction, value) ->
            when (direction) {
                "forward" -> { horizontal += value; depth += aim * value }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }

    return depth * horizontal
}

fun main() {
    println(dive1())
    println(dive2())
}