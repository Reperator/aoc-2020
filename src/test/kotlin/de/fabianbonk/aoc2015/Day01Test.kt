package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/01: Not Quite Lisp")
class Day01Test {
    private val reference = javaClass
        .getResource("/2015/input-01.txt")
        .readText()
        .trim()

    @Nested
    inner class PartOne {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(0, "(())", "tutorial input 1"),
            arguments(0, "()()", "tutorial input 2"),
            arguments(3, "(((", "tutorial input 3"),
            arguments(3, "(()(()(", "tutorial input 4"),
            arguments(3, "))(((((", "tutorial input 5"),
            arguments(-1, "())", "tutorial input 6"),
            arguments(-1, "))(", "tutorial input 7"),
            arguments(-3, ")))", "tutorial input 8"),
            arguments(-3, ")())())", "tutorial input 9"),
            arguments(280, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day01.partOne(input))
        }
    }

    @Nested
    inner class PartTwo {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(1, ")", "tutorial input 1"),
            arguments(5, "()())", "tutorial input 2"),
            arguments(1797, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: String, name: String) {
            assertEquals(expected, Day01.partTwo(input))
        }
    }
}
