package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/07: Some Assembly Required")
@Suppress("unused", "UNUSED_PARAMETER")
class Day07Test {
    private val reference = javaClass
        .getResource("/2015/input-07.txt")
        .readText()
        .trim()
        .lines()

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(72, listOf("123 -> x", "456 -> y", "x AND y -> a"), "tutorial input (d)"),
            arguments(507, listOf("123 -> x", "456 -> y", "x OR y -> a"), "tutorial input (e)"),
            arguments(492, listOf("123 -> x", "x LSHIFT 2 -> a"), "tutorial input (f)"),
            arguments(114, listOf("456 -> y", "y RSHIFT 2 -> a"), "tutorial input (g)"),
            arguments(65412, listOf("123 -> x", "NOT x -> a"), "tutorial input (h)"),
            arguments(65079, listOf("456 -> y", "NOT y -> a"), "tutorial input (i)"),
            arguments(123, listOf("123 -> a"), "tutorial input (x)"),
            arguments(456, listOf("456 -> a"), "tutorial input (y)"),
            arguments(2, listOf("b -> a", "2 AND 3 -> b"), "don't require forward declaration"),
            arguments(956, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day07.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        private fun `valid inputs`() = listOf(
            arguments(40149, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day07.partTwo(input))
        }
    }
}
