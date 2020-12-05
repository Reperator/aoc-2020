package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/06: Probably a Fire Hazard")
@Suppress("unused", "UNUSED_PARAMETER")
class Day06Test {
    private val reference = javaClass
        .getResource("/2015/input-06.txt")
        .readText()
        .trim()
        .lines()

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(
                998996,
                listOf(
                    "turn on 0,0 through 999,999",
                    "toggle 0,0 through 999,0",
                    "turn off 499,499 through 500,500",
                ),
                "tutorial input"
            ),
            arguments(377891, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day06.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        private fun `valid inputs`() = listOf(
            arguments(
                2000001,
                listOf(
                    "turn on 0,0 through 0,0",
                    "toggle 0,0 through 999,999",
                ),
                "tutorial input"
            ),
            arguments(14110788, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day06.partTwo(input))
        }
    }
}
