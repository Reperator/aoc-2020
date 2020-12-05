package de.fabianbonk.aoc2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2020/05: Binary Boarding")
@Suppress("unused", "UNUSED_PARAMETER")
class Day05Test {
    private val reference = javaClass
        .getResource("/2020/input-05.txt")
        .readText()
        .trim()
        .lines()

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(357, listOf("FBFBBFFRLR"), "tutorial input 1"),
            arguments(567, listOf("BFFFBBFRRR"), "tutorial input 2"),
            arguments(119, listOf("FFFBBBFRRR"), "tutorial input 3"),
            arguments(820, listOf("BBFFBBFRLL"), "tutorial input 4"),
            arguments(978, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day05.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        private fun `valid inputs`() = listOf(
            arguments(727, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day05.partTwo(input))
        }
    }
}
