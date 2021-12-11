package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week2Tests {

    @Test
    fun `test Day 8 Seven Segment Search Part One`() {
        assertEquals(239, sevenSegmentSearch1())
    }

    @Test
    fun `test Day 8 Seven Segment Search Part Two`() {
        assertEquals(946346, sevenSegmentSearch2())
    }

    @Test
    fun `test Day 9 Smoke Basin Part One`() {
        assertEquals(506, smokeBasin1())
    }

    @Test
    fun `test Day 9 Smoke Basin Part Two`() {
        assertEquals(931200, smokeBasin2())
    }

    @Test
    fun `test Day 10 Syntax Scoring Part One`() {
        assertEquals(290691, syntaxScoring1())
    }

    @Test
    fun `test Day 10 Syntax Scoring Part Two`() {
        assertEquals(2768166558, syntaxScoring2())
    }

    @Test
    fun `test Day 11 Dumbo Octopus Part One`() {
        assertEquals(1615, dumboOctopus1())
    }

    @Test
    fun `test Day 11 Dumbo Octopus Part Two`() {
        assertEquals(249, dumboOctopus2())
    }
}