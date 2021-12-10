package com.github.markaalvaro.advent2021

import java.util.*

private const val FILE_NAME = "Day10.txt"

val openBrackets = setOf('(', '[', '{', '<')
val openToClose = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
val closeToScore1 = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
val closeToScore2 = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

fun syntaxScoring1(): Int {
    val nums: List<Int> = readFile(FILE_NAME)
        .map {
            val stack = Stack<Char>()
            for (bracket in it.toList()) {
                if (bracket in openBrackets) stack.push(openToClose[bracket])
                else {
                    if (stack.peek() == bracket) stack.pop()
                    else return@map closeToScore1[bracket]!!
                }
            }
            0
        }

    return nums.sum()
}

fun syntaxScoring2(): Long {
    val scores = readFile(FILE_NAME)
        .map {
            val stack = Stack<Char>()
            for (bracket in it.toList()) {
                if (bracket in openBrackets) stack.push(openToClose[bracket])
                else {
                    if (stack.peek() == bracket) stack.pop()
                    else return@map 0
                }
            }

            stack.reversed()
                .fold(0L) { acc, bracket -> acc * 5 + closeToScore2[bracket]!! }
        }
        .filter { it != 0L }
        .sorted()

    return scores[scores.size / 2]
}

fun main() {
    println(syntaxScoring1())
    println(syntaxScoring2())
}