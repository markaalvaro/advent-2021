package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week1Tests {

    @Test
    fun `test Day 1 Sonar Sweep Part One`() {
        assertEquals(1759, sonarSweep1())
    }

    @Test
    fun `test Day 1 Sonar Sweep Part Two`() {
        assertEquals(1805, sonarSweep2())
    }

    @Test
    fun `test Day 2 Dive Part One`() {
        assertEquals(1924923, dive1())
    }

    @Test
    fun `test Day 2 Dive Part Two`() {
        assertEquals(1982495697, dive2())
    }

    @Test
    fun `test Day 3 Binary Diagnostic One`() {
        assertEquals(2035764, binaryDiagnostic1())
    }

    @Test
    fun `test Day 3 Binary Diagnostic Part Two`() {
        assertEquals(2817661, binaryDiagnostic2())
    }

    @Test
    fun `test Day 4 Giant Squid Part One`() {
        assertEquals(44736, giantSquid1())
    }

    @Test
    fun `test Day 4 Giant Squid Part Two`() {
        assertEquals(1827, giantSquid2())
    }

    @Test
    fun `test Day 5 Hydrothermal Venture Part One`() {
        assertEquals(6841, hydrothermalVenture1())
    }

    @Test
    fun `test Day 5 Hydrothermal Venture Part Two`() {
        assertEquals(19258, hydrothermalVenture2())
    }
}