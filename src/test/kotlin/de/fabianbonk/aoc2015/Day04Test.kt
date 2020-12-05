package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/04: The Ideal Stocking Stuffer")
@Suppress("unused", "UNUSED_PARAMETER")
class Day04Test {
    private val reference = "ckczppom"

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(609043, "abcdef", "tutorial input 1"),
            arguments(1048970, "pqrstuv", "tutorial input 2"),
            arguments(117946, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day04.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        private fun `valid inputs`() = listOf(
            arguments(3938038, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day04.partTwo(input))
        }
    }
}
