package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AdventOfCodeTests {

    @Test
    fun `test Day 1 Sonar Sweep Part One`() {
        assertEquals(1759, sonarSweep1(DAY_1_FILE_NAME))
    }

    @Test
    fun `test Day 1 Sonar Sweep Part Two`() {
        assertEquals(1805, sonarSweep2(DAY_1_FILE_NAME))
    }

    @Test
    fun `test Day 2 Dive Part One`() {
        assertEquals(1924923, dive1(DAY_2_FILE_NAME))
    }

    @Test
    fun `test Day 2 Dive Part Two`() {
        assertEquals(1982495697, dive2(DAY_2_FILE_NAME))
    }
}