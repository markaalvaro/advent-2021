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
}