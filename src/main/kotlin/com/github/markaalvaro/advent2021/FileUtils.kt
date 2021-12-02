package com.github.markaalvaro.advent2021

fun readFile(fileName: String): List<String> {
    return object {}.javaClass.classLoader.getResource(fileName)!!
        .readText(Charsets.UTF_8)
        .lines()
        .map { it.trim() }
}

fun <T> readFile(fileName: String, transformation: (String) -> T): List<T> {
    return readFile(fileName)
        .map(transformation)
}
