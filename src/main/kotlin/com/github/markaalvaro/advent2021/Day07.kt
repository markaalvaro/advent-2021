package com.github.markaalvaro.advent2021

import kotlin.math.abs

private const val FILE_NAME = "Day07.txt"

fun treacheryOfWhales1(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }
        .toMutableList()

    val costs = mutableListOf<Int>()
    costs.add(input.sum())

    for (i in 1..input.lastIndex) {
        var cost = costs[i - 1]
        input.forEach {
            if (gettingCloser(it, i)) cost--
            else cost++
        }
        costs.add(cost)
    }

    return costs.minOrNull()!!
}

data class Value(val num: Int, var cost: Int, var diff: Int)

fun treacheryOfWhales2(): Int {
    val input = readFile(FILE_NAME)[0]
        .split(",")
        .map { it.toInt() }
        .map { num ->
            val cost = triangularNumber(num)
            Value(num, cost, num)
        }

    val costs = mutableListOf<Int>()
    costs.add(input.sumOf { it.cost })

    for (i in 1..input.lastIndex) {
        var cost = costs[i - 1]
        input.forEach {
            if (gettingCloser(it.num, i)) {
                cost -= it.diff
                it.diff--
            } else {
                it.diff++
                cost += it.diff
            }
        }
        costs.add(cost)
    }

    return costs.minOrNull()!!
}

fun main() {
    println(treacheryOfWhales1())
    println(treacheryOfWhales2())
}

val memoized = mutableMapOf<Int, Int>()
private fun triangularNumber(n: Int): Int {
    if (memoized.containsKey(n)) return memoized[n]!!
    val result = (n * (n + 1)) / 2
    memoized[n] = result
    return result
}

private fun gettingCloser(num: Int, index: Int): Boolean {
    return abs(num - (index - 1)) > abs(num - index)
}
