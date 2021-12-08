package com.github.markaalvaro.advent2021

import kotlin.math.abs
import kotlin.math.min

private const val FILE_NAME = "Day07.txt"

fun treacheryOfWhales1(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }

    var previousCost = input.sum()
    var minCost = previousCost

    for (i in 1..input.lastIndex) {
        var cost = previousCost
        input.forEach {
            if (abs(it - (i - 1)) > abs(it - i)) cost--
            else cost++
        }
        minCost = min(minCost, cost)
        previousCost = cost
    }

    return minCost
}

data class Value(val num: Int, var diff: Int) {
    fun gettingCloser(index: Int) = abs(num - (index - 1)) > abs(num - index)
}

fun treacheryOfWhales2(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }
        .map { num -> Value(num, num) }

    var previousCost = input.sumOf { triangularNumber(it.num) }
    var minCost = previousCost

    for (i in 1..input.lastIndex) {
        var cost = previousCost
        input.forEach {
            if (it.gettingCloser(i)) cost -= it.diff--
            else cost += ++it.diff
        }
        minCost = min(minCost, cost)
        previousCost = cost
    }

    return minCost
}

fun main() {
    println(treacheryOfWhales1())
    println(treacheryOfWhales2())
}

val memoized = mutableMapOf<Int, Int>()
private fun triangularNumber(n: Int): Int {
    return memoized[n] ?: run {
        val result = (n * (n + 1)) / 2
        memoized[n] = result
        result
    }
}
