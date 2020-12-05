package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/03: Perfectly Spherical Houses in a Vacuum")
@Suppress("unused", "UNUSED_PARAMETER")
class Day03Test {
    private val reference = javaClass
        .getResource("/2015/input-03.txt")
        .readText()
        .trim()

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(2, ">", "tutorial input 1"),
            arguments(4, "^>v<", "tutorial input 2"),
            arguments(2, "^v^v^v^v^v", "tutorial input 3"),
            arguments(2565, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day03.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        private fun `valid inputs`() = listOf(
            arguments(3, "^v", "tutorial input 1"),
            arguments(3, "^>v<", "tutorial input 2"),
            arguments(11, "^v^v^v^v^v", "tutorial input 3"),
            arguments(2639, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day03.partTwo(input))
        }
    }
}
