package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day06.txt"

fun lanternfish1(): Long {
    return countFish(80)
}

fun lanternfish2(): Long {
    return countFish(256)
}

fun countFish(days: Int) : Long {
    val fish = mutableMapOf<Int, Long>()
    readFile(FILE_NAME).forEach { line ->
        line.split(",")
            .map { it.toInt() }
            .forEach { fish[it] = (fish[it] ?: 0) + 1 }
    }

    repeat(days) {
        val newFish = fish[0] ?: 0
        for (i in 0..7)
            fish[i] = fish[i+1] ?: 0
        fish[8] = newFish
        fish[6] = (fish[6] ?: 0) + newFish
    }

    return fish.values.sum()
}

fun main() {
    println(lanternfish1())
    println(lanternfish2())
}