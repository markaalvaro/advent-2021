package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week3Tests {

    @Test
    fun `test Day 8 Chiton Part One`() {
        assertEquals(619, chiton1())
    }

    @Disabled
    @Test
    fun `test Day 8 Chiton Part Two`() {
        assertEquals(2922, chiton2())
    }
}