package com.github.markaalvaro.advent2021

import kotlin.math.abs
import kotlin.math.min

private const val FILE_NAME = "Day07.txt"

fun treacheryOfWhales1(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }
        .toMutableList()

    var previousCost = input.sum()
    var minCost = previousCost

    for (i in 1..input.lastIndex) {
        var cost = previousCost
        input.forEach {
            if (gettingCloser(it, i)) cost--
            else cost++
        }
        minCost = min(minCost, cost)
        previousCost = cost
    }

    return minCost
}

data class Value(val num: Int, var cost: Int, var diff: Int)

fun treacheryOfWhales2(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }
        .map { num -> Value(num, triangularNumber(num), num) }

    var previousCost = input.sumOf { it.cost }
    var minCost = previousCost

    for (i in 1..input.lastIndex) {
        var cost = previousCost
        input.forEach {
            if (gettingCloser(it.num, i)) cost -= it.diff--
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

private fun gettingCloser(num: Int, index: Int): Boolean {
    return abs(num - (index - 1)) > abs(num - index)
}
