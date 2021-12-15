package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day14.txt"

fun extendedPolymerization1(): Int {
    val input = readFile(FILE_NAME)
    var polymer = input[0]
    val mappings = input.drop(2).map { it.split(" -> ") }
        .associate { (pair, rule) -> Pair(pair, rule) }

    repeat(10) {
        val toInsert = mutableListOf<Pair<String, Int>>()

        polymer.withIndex().windowed(2)
            .forEach {
                val left = it[0].value
                val right = it[1].value
                val pair = left.toString() + right
                toInsert.add(Pair(mappings[pair]!!, it[1].index))
            }

        val polymerList = polymer.toMutableList()
        var count = 0
        toInsert.forEach { (char, index) -> polymerList.add(index + count++, char[0]) }

        polymer = polymerList.joinToString("")
    }

    val counts = polymer.toList().groupingBy { it }.eachCount().values
    return counts.maxOf { it } - counts.minOf { it }
}

fun extendedPolymerization2(): Long {
    val input = readFile(FILE_NAME)
    val polymer = input[0]
    val mappings = input.drop(2).map { it.split(" -> ") }
        .associate { (pair, rule) -> Pair(pair, rule) }

    var characterPairs: Map<String, Long> = polymer.toList()
        .windowed(2)
        .map { it.joinToString("") }
        .groupingBy { it }
        .eachCount()
        .map { (pair, count) -> Pair(pair, count.toLong()) }
        .toMap()

    repeat(40) {
        val newCharacterPairs = mutableMapOf<String, Long>()

        characterPairs.forEach { (pair, count) ->
            val mapping = mappings[pair]!!
            val newLeft = pair[0] + mapping
            val newRight = mapping + pair[1]
            newCharacterPairs[newLeft] = newCharacterPairs.getOrDefault(newLeft, 0) + count
            newCharacterPairs[newRight] = newCharacterPairs.getOrDefault(newRight, 0) + count
        }

        characterPairs = newCharacterPairs
    }

    val counts = characterPairs.toList().groupBy { it.first[0] }.map {
        it.value.sumOf { pair -> pair.second } + (if (it.key == polymer[polymer.lastIndex]) 1 else 0)
    }

    return counts.maxOf { it } - counts.minOf { it }
}

fun main() {
    println(extendedPolymerization1())
    println(extendedPolymerization2())
}