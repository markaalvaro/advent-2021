package com.github.markaalvaro.advent2021

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week3Tests {

    @Test
    fun `test Day 15 Chiton Part One`() {
        assertEquals(619, chiton1())
    }

    @Disabled("This should work, but it's too slow, especially to run on GitHub Actions")
    @Test
    fun `test Day 15 Chiton Part Two`() {
        assertEquals(2922, chiton2())
    }
}