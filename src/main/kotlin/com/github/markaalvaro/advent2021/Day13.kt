package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day13.txt"

fun transparentOragami1(): Int {
    val input = readFile(FILE_NAME)
    var grid = createGrid(input)

    input.first { it.startsWith("fold") }
        .let {
            val (instruction, value) = it.split("=")
            grid = if (instruction.endsWith("x")) grid.xFold(value.toInt()) else grid.yFold(value.toInt())
        }

    return grid.flatMap { it.toList() }.sumOf { it }
}

fun transparentOragami2(): Int {
    val input = readFile(FILE_NAME)
    var grid = createGrid(input)

    input.dropWhile { !it.startsWith("fold") }
        .map { it.split("=") }
        .forEach { (instruction, value) ->
            grid = if (instruction.endsWith("x")) grid.xFold(value.toInt()) else grid.yFold(value.toInt())
        }

    grid.prettyPrint()

    return grid.flatMap { it.toList() }.sumOf { it }
}

fun main() {
    println(transparentOragami1())
    println(transparentOragami2())
}

private fun createGrid(input: List<String>): Array<IntArray> {
    val coords = input.takeWhile { it.isNotBlank() }
        .map { it.split(",") }
        .map { (first, second) -> Pair(second.toInt(), first.toInt()) } // reverse to use sane indexing
        .toSet()
    var rows = coords.maxOf { it.first } + 1; if (rows % 2 == 0) rows++
    var cols = coords.maxOf { it.second } + 1; if (cols % 2 == 0) cols++
    return Array(rows) { r -> IntArray(cols) { c -> if (Pair(r, c) in coords) 1 else 0 } }
}

private fun Array<IntArray>.xFold(value: Int): Array<IntArray> {
    val result = map { it.take(value).toIntArray() }
        .toTypedArray()
    for (r in 0..result.lastIndex)
        for (c in 0..result[r].lastIndex)
            result[r][c] = result[r][c] or this[r][this[r].lastIndex - c]
    return result
}

private fun Array<IntArray>.yFold(value: Int): Array<IntArray> {
    val result = take(value).toTypedArray()
    for (r in 0..result.lastIndex)
        for (c in 0..result[r].lastIndex)
                result[r][c] = result[r][c] or this[this.lastIndex - r][c]
    return result
}

private fun Array<IntArray>.prettyPrint() {
    for (r in 0..lastIndex) {
        for (c in 0..this[r].lastIndex) {
            print("${if (this[r][c] == 1) '#' else ' '}")
        }
        println()
    }
}