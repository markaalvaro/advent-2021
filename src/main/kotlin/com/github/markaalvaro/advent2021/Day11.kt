package com.github.markaalvaro.advent2021

import kotlin.math.max
import kotlin.math.min

private const val FILE_NAME = "Day11.txt"

data class Octopus(var energy: Int, var flashed: Boolean = false)

typealias Octopi = List<List<Octopus>>

fun dumboOctopus1(): Int {
    val octopi = readFile(FILE_NAME) { it.toList() }
        .map { it.map(Character::getNumericValue).map(::Octopus) }
    var totalFlashes = 0

    repeat(100) {
        octopi.raiseEnergy()
        totalFlashes += octopi.flash()
        octopi.reset()
    }

    return totalFlashes
}

fun dumboOctopus2(): Int {
    val octopi = readFile(FILE_NAME) { it.toList() }
        .map { it.map(Character::getNumericValue).map(::Octopus) }

    var allFlashed = false
    var step = 0

    while (!allFlashed) {
        step++
        octopi.raiseEnergy()
        octopi.flash()
        allFlashed = octopi.reset()
    }

    return step
}

fun main() {
    println(dumboOctopus1())
    println(dumboOctopus2())
}

private fun Octopi.raiseEnergy(): Unit = forEach { octopus, _, _ -> octopus.energy++ }

private fun Octopi.flash(): Int {
    var totalFlashes = 0
    forEach { octopus, r, c ->
        if (octopus.energy > 9 && !octopus.flashed)
            totalFlashes += flashRecursive(this, r, c)
    }
    return totalFlashes
}

private fun Octopi.reset(): Boolean {
    var allFlashed = true
    forEach { octopus, _, _ ->
        if (octopus.flashed) octopus.energy = 0
        if (!octopus.flashed) allFlashed = false
        octopus.flashed = false
    }
    return allFlashed
}

private fun flashRecursive(input: Octopi, row: Int, col: Int): Int {
    var total = 1
    input[row][col].flashed = true

    for (r in max(0, row - 1)..min(input.lastIndex, row + 1))
        for (c in max(0, col - 1)..min(input[0].lastIndex, col + 1)) {
            val current = input[r][c]
            current.energy++
            if (current.energy > 9 && !current.flashed) {
                total += flashRecursive(input, r, c)
            }
        }

    return total
}

private fun Octopi.forEach(function: (Octopus, Int, Int) -> Unit) {
    for (r in 0..lastIndex)
        for (c in 0..this[0].lastIndex)
            function(this[r][c], r, c)
}