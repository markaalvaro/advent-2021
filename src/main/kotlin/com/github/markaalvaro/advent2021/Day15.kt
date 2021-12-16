package com.github.markaalvaro.advent2021

import java.util.*

private const val FILE_NAME = "Day15.txt"

data class Position(val risk: Int, var cumulative: Int = Int.MAX_VALUE, var row: Int? = null, var col: Int? = null) {
    override fun equals(other: Any?) = other is Position && row == other.row && col == other.col
    override fun hashCode() = Objects.hash(row, col)
}

fun chiton1(): Int {
    val riskLevels = getRiskLevels()
    riskLevels[0][0].cumulative = 0

    for (r in 0..riskLevels.lastIndex) {
        for (c in 0..riskLevels[0].lastIndex) {
            riskLevels[r][c].row = r
            riskLevels[r][c].col = c
        }
    }

    return shortestPath(riskLevels)
}

// This is too slow and something I should probably come back to.
fun chiton2(): Int {
    val riskLevelsOriginal = getRiskLevels()

    val riskLevels = Array(riskLevelsOriginal.size * 5)
    { r ->
        Array(riskLevelsOriginal[0].size * 5)
        { c -> calculateRisk(riskLevelsOriginal, r, c) }
    }
    riskLevels[0][0].cumulative = 0

    return shortestPath(riskLevels)
}

fun main() {
    println(chiton1())
    println(chiton2())
}

fun getRiskLevels(): Array<Array<Position>> {
    return readFile(FILE_NAME) {
        it.toList()
            .map(Character::getNumericValue)
            .map(::Position)
            .toTypedArray()
    }
        .toTypedArray()
}

fun shortestPath(riskLevels: Array<Array<Position>>): Int {
    val unvisited = riskLevels.map { it.toList() }.flatten().toMutableSet()

    while (unvisited.isNotEmpty()) {
        val current = unvisited.minByOrNull { it.cumulative }!!
        modifyNeighbors(riskLevels, current)
        unvisited.remove(current)
    }

    return riskLevels[riskLevels.lastIndex][riskLevels[0].lastIndex].cumulative
}

private fun modifyNeighbors(riskLevels: Array<Array<Position>>, current: Position) {
    val currentRisk = current.cumulative
    val row = current.row!!
    val col = current.col!!

    if (col != 0) modifyNeighbor(riskLevels[row][col - 1], currentRisk)
    if (col != riskLevels[0].lastIndex) modifyNeighbor(riskLevels[row][col + 1], currentRisk)
    if (row != riskLevels.lastIndex) modifyNeighbor(riskLevels[row + 1][col], currentRisk)
    if (row != 0) modifyNeighbor(riskLevels[row - 1][col], currentRisk)
}

private fun modifyNeighbor(neighbor: Position, currentRisk: Int) {
    val newRisk = neighbor.risk + currentRisk
    if (newRisk < neighbor.cumulative) neighbor.cumulative = newRisk
}

private fun calculateRisk(riskLevelsOriginal: Array<Array<Position>>, row: Int, col: Int): Position {
    var risk = riskLevelsOriginal[row % riskLevelsOriginal.size][col % riskLevelsOriginal[0].size].risk
    risk += row / riskLevelsOriginal.size
    risk += col / riskLevelsOriginal[0].size
    if (risk > 9) risk -= 9
    return Position(risk, Int.MAX_VALUE, row, col)
}
