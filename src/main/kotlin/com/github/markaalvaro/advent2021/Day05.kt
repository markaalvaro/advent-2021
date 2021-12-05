package com.github.markaalvaro.advent2021

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

private const val FILE_NAME = "Day05.txt"

data class Point(val x: Int, val y: Int)
data class Segment(val start: Point, val end: Point) {

    fun normalize(): Segment {
        return if (isDiagonal()) this else Segment(
            Point(min(start.x, end.x), min(start.y, end.y)),
            Point(max(start.x, end.x), max(start.y, end.y))
        )
    }

    fun isDiagonal(): Boolean {
        return start.x != end.x && start.y != end.y
    }

    /**
     * Note: This method should only be called on a normalized segment. For simplicity, omitting a precondition check.
     */
    fun getPoints(): List<Point> {
        val points = mutableListOf<Point>()

        if (isDiagonal()) {
            var x = start.x
            var y = start.y
            repeat(abs(start.x - end.x) + 1) {
                points.add(Point(x, y))
                if (start.x < end.x) x++ else x--
                if (start.y < end.y) y++ else y--
            }
        } else {
            for (x in start.x..end.x)
                for (y in start.y..end.y)
                    points.add(Point(x, y))
        }

        return points
    }
}

fun hydrothermalVenture1(): Int {
    return countOverlappingPoints { !it.isDiagonal() }
}

fun hydrothermalVenture2(): Int {
    return countOverlappingPoints()
}

private fun countOverlappingPoints(filter: (Segment) -> Boolean = { true }): Int {
    val pointCounts = mutableMapOf<Point, Int>()

    readFile(FILE_NAME) {
        it.split(" -> ")
            .map { pointString -> pointString.split(",") }
            .map { (x, y) -> Point(x.toInt(), y.toInt()) }
    }
        .map { (start, end) -> Segment(start, end).normalize() }
        .filter(filter)
        .forEach { segment ->
            segment.getPoints().forEach {
                pointCounts[it] = (pointCounts[it] ?: 0) + 1
            }
        }

    return pointCounts.values.count { it > 1 }
}

fun main() {
    println(hydrothermalVenture1())
    println(hydrothermalVenture2())
}