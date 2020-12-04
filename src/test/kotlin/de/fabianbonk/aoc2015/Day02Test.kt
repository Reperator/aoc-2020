package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/02: I Was Told There Would Be No Math")
class Day02Test {
    private val reference = javaClass
        .getResource("/2015/input-02.txt")
        .readText()
        .trim()
        .lines()

    @Nested
    inner class PartOne {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(58, listOf("2x3x4"), "tutorial input 1"),
            arguments(43, listOf("1x1x10"), "tutorial input 2"),
            arguments(1586300, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day02.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(34, listOf("2x3x4"), "tutorial input 1"),
            arguments(14, listOf("1x1x10"), "tutorial input 2"),
            arguments(3737498, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day02.partTwo(input))
        }
    }
}
