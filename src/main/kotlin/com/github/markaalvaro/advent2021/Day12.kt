package com.github.markaalvaro.advent2021

private const val FILE_NAME = "Day12.txt"
private const val START = "start"
private const val END = "end"

data class Link(val name: String, val links: MutableSet<Link> = mutableSetOf()) {
    override fun equals(other: Any?) = name == (other as Link).name
    override fun hashCode() = name.hashCode()
}

fun passagePathing1(): Int {
    return passagePathing(false)
}

fun passagePathing2(): Int {
    return passagePathing(true)
}

fun passagePathing(allowDoubleVisit: Boolean): Int {
    val paths = getPaths()

    var counter = 0
    while (paths.isNotEmpty()) {
        for (path in paths.toList()) {
            val lastLink = path.last()

            val visited = path.map { it.name }.toSet()
            val visitedTwice = path.groupingBy { it.name }.eachCount()
                .filter { (value, count) -> count > 1 && !value[0].isUpperCase() }
                .any()

            paths.remove(path)
            if (lastLink.name == END) {
                counter++
            } else {
                for (toLink in lastLink.links) {
                    if (toLink.name !in visited || (allowDoubleVisit && !visitedTwice) || toLink.name[0].isUpperCase())
                        paths += path + toLink
                }
            }
        }
    }

    return counter
}

fun main() {
    println(passagePathing1())
    println(passagePathing2())
}

private fun getPaths(): MutableSet<List<Link>> {
    val paths = mutableSetOf<List<Link>>()
    val graph = mutableMapOf<String, Link>()

    readFile(FILE_NAME) { it.split("-") }
        .forEach { (from, to) ->
            val fromLink = graph.getOrPut(from) { Link(from) }
            val toLink = graph.getOrPut(to) { Link(to) }

            if (toLink.name != START) fromLink.links.add(toLink)
            if (fromLink.name != START) toLink.links.add(fromLink)

            if (fromLink.name == START && paths.isEmpty()) paths += mutableListOf(fromLink)
            if (toLink.name == START && paths.isEmpty()) paths += mutableListOf(toLink)
        }

    return paths
}