package com.github.markaalvaro.advent2021

// We don't need to calculate sums to compare consecutive windows, as we know
// b+c+d > a+b+c iff d > a (since the b+c part is common on both sides)
fun sonarSweep2Alt(): Int {
    return readFile("Day01.txt") { it.toInt() }
        .windowed(4)
        .count { (a, _, _, d) -> d > a }
}

fun main() {
    println(sonarSweep2Alt())
}