package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day04.txt"

fun giantSquid1(): Int {
    val input = readFile(FILE_NAME)
    val numbers = getNumbers(input)
    val boards = getBoards(input)

    val numsSoFar = mutableSetOf<Int>()
    for (num in numbers) {
        numsSoFar.add(num)
        boards.firstOrNull { isBingo(it, numsSoFar) }?.let { return calculateScore(it, numsSoFar) }
    }

    throw IllegalStateException("Expected at least one winning bingo")
}

fun giantSquid2(): Int {
    val input = readFile(FILE_NAME)
    val numbers = getNumbers(input)
    var boards = getBoards(input)

    val numsSoFar = mutableSetOf<Int>()
    for (num in numbers) {
        numsSoFar.add(num)
        if (boards.size == 1) {
            if (isBingo(boards.first(), numsSoFar))
                return calculateScore(boards.first(), numsSoFar)
        }
        else
            boards = boards.filter { !isBingo(it, numsSoFar) }.toList()
    }

    throw IllegalStateException("Expected a single last board to win")
}

fun main() {
    println(giantSquid1())
    println(giantSquid2())
}

private fun getNumbers(input: List<String>): List<Int> {
    return input[0].split(",").map { it.toInt() }
}

private fun getBoards(input: List<String>): List<List<Int>> {
    return input.drop(2)
        .chunked(6)
        .map { boardLines ->
            boardLines.take(5)
                .flatMap { it.split("\\s+".toRegex()) }
                .map { it.toInt() }
        }
        .toList()
}

private fun isBingo(board: List<Int>, numbers: Set<Int>): Boolean {
    for (i in 0..4) {
        // Check rows
        val start = i * 5
        val row = listOf(board[start], board[start + 1], board[start + 2], board[start + 3], board[start + 4])
        if (numbers.containsAll(row)) return true

        // Check columns
        val column = listOf(board[i], board[i + 5], board[i + 10], board[i + 15], board[i + 20])
        if (numbers.containsAll(column)) return true
    }
    return false
}

private fun calculateScore(board: List<Int>, numsSoFar: Set<Int>): Int {
    return (board - numsSoFar.toSet()).sum() * numsSoFar.last()
}