package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day08.txt"

fun <K, V> Map<K, V>.reverse() = map { Pair(it.value, it.key) }.toMap()

fun sevenSegmentSearch1() : Int {
    val interestingLengths = setOf(2, 3, 4, 7)
    return readFile(FILE_NAME) { it.split(" | ")[1] }
        .flatMap { it.split(" ") }
        .count { it.length in interestingLengths }
}

fun sevenSegmentSearch2() : Int {
    return readFile(FILE_NAME) { it.split(" | ") }
        .map { (clues, display) -> Pair(clues.split(' '), display) }
        .sumOf { (clues, display) ->
            val letterMappings = mutableMapOf<Char, Char>()

            val characterCounts = clues.map { it.toList() }.flatten().groupingBy { it }.eachCount()
            val charactersByCount = characterCounts.reverse()

            val bTransformed = charactersByCount[6]!!
            letterMappings[bTransformed] = 'b'
            letterMappings[charactersByCount[4]!!] = 'e'
            val fTransformed = charactersByCount[9]!!
            letterMappings[fTransformed] = 'f'

            val cluesByLength = clues.map { it.toSet() }.toList().associateBy { it.size }
            val aTransformed = (cluesByLength[3]!! - cluesByLength[2]!!).first()
            letterMappings[aTransformed] = 'a'

            val cTransformed = characterCounts.toList().filter { (character, count) -> count == 8 && character != aTransformed }.map { it.first }[0]
            letterMappings[cTransformed] = 'c'

            val dTransformed = (cluesByLength[4]!! - setOf(bTransformed, cTransformed, fTransformed)).first()
            letterMappings[dTransformed] = 'd'

            val gTransformed = (setOf('a', 'b', 'c', 'd', 'e', 'f', 'g') - letterMappings.keys).first()
            letterMappings[gTransformed] = 'g'

            display.split(" ").map { clue -> clue.toList().map { letterMappings[it] }.toSet() }
                .map { numbers[it] }
                .joinToString("")
                .toInt()
        }
}

fun main() {
    println(sevenSegmentSearch1())
    println(sevenSegmentSearch2())
}

val numbers = mapOf(
    setOf('a', 'b', 'c', 'e', 'f', 'g') to 0,
    setOf('c', 'f') to 1,
    setOf('a', 'c', 'd', 'e', 'g') to 2,
    setOf('a', 'c', 'd', 'f', 'g') to 3,
    setOf('b', 'c', 'd', 'f') to 4,
    setOf('a', 'b', 'd', 'f', 'g') to 5,
    setOf('a', 'b', 'd', 'e', 'f', 'g') to 6,
    setOf('a', 'c', 'f') to 7,
    setOf('a', 'b', 'c', 'd', 'e', 'f', 'g') to 8,
    setOf('a', 'b', 'c', 'd', 'f', 'g') to 9,
)