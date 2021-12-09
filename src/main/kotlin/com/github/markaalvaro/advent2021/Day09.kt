package com.github.markaalvaro.advent2021

import kotlin.math.max
import kotlin.math.min

private const val FILE_NAME = "Day09.txt"

data class Node(val size: Int, var basin: Int? = null)

fun List<List<Node>>.isLow(row: Int, col: Int): Boolean {
    for (r in max(0, row - 1)..min(lastIndex, row + 1))
        for (c in max(0, col - 1)..min(this[0].lastIndex, col + 1))
            if ((r != row || c != col) && this[r][c].size <= this[row][col].size) return false
    return true
}

fun smokeBasin1(): Int {
    val input = readFile(FILE_NAME) { it.toList() }
        .map { it.map(Character::getNumericValue).map { size -> Node(size) } }

    var sum = 0
    for (r in 0..input.lastIndex)
        for (c in 0..input[0].lastIndex)
            if (input.isLow(r, c)) sum += input[r][c].size + 1

    return sum
}

fun smokeBasin2(): Int {
    val input = readFile(FILE_NAME) { it.toList() }
        .map { it.map(Character::getNumericValue).map { size -> Node(size) } }

    var nextBasin = 0
    for (r in 0..input.lastIndex)
        for (c in 0..input[0].lastIndex)
            if (input.isLow(r, c)) explode(input, r, c, nextBasin++)

    return input.flatten()
        .filter { it.basin != null }
        .groupingBy { it.basin }
        .eachCount()
        .values
        .sortedDescending()
        .take(3)
        .reduce(Int::times)
}

fun explode(input: List<List<Node>>, row: Int, col: Int, basin: Int) {
    input[row][col].basin = basin
    for ((r, c) in listOf(row - 1 to col, row to col - 1, row to col + 1, row + 1 to col)) {
        if (r !in 0..input.lastIndex || c !in 0..input[0].lastIndex) continue
        val neighbor = input[r][c]
        if (neighbor.size != 9 && neighbor.basin == null)
            explode(input, r, c, basin)
    }
}

fun main() {
    println(smokeBasin1())
    println(smokeBasin2())
}