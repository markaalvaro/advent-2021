package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AdventOfCodeTests {

    @Test
    fun `test Day 1 Sonar Sweep Part One`() {
        assertEquals(1759, depthIncreases(DAY_1_FILE_NAME))
    }

    @Test
    fun `test Day 1 Sonar Sweep Part Two`() {
        assertEquals(1805, depthSumIncreases(DAY_1_FILE_NAME))
    }
}