package de.fabianbonk.exercise

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Day 02: Password Philosophy")
class Day02Test {
    private val tutorial = listOf(
        Policy(1, 3, 'a') to "abcde",
        Policy(1, 3, 'b') to "cdefg",
        Policy(2, 9, 'c') to "ccccccccc",
    )

    private val reference = javaClass
        .getResource("/input-02.txt")
        .readText()
        .trim()
        .lines()
        .map {
            val (policy, password) = it.split(": ")
            Policy.ofString(policy) to password
        }

    @Nested
    inner class PartOne {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(2, tutorial, "tutorial input"),
            arguments(418, reference, "reference input"),
            arguments(1, listOf(Policy(1, 2, 'A') to "AA"), "uppercase"),
            arguments(1, listOf(Policy(1, 1, 'a') to "abc"), "a == b"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<Pair<Policy, String>>, name: String) {
            assertEquals(expected, Day02.partOne(input))
        }

        @Suppress("unused")
        private fun `invalid inputs`() = listOf(
            arguments(listOf(Policy(-1, 2, 'a') to ""), "a < 0"),
            arguments(listOf(Policy(1, -2, 'a') to ""), "b < 0"),
            arguments(listOf(Policy(2, 1, 'a') to ""), "b < a"),
        )

        @ParameterizedTest(name = "{1}")
        @MethodSource
        fun `invalid inputs`(input: List<Int>, name: String) {
            assertThrows<IllegalArgumentException> {
                Day01.partTwo(input)
            }
        }
    }

    @Nested
    inner class PartTwo {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(1, tutorial, "tutorial input"),
            arguments(616, reference, "reference input"),
            arguments(0, listOf(Policy(1, 2, 'a') to "aa"), "either a or b"),
            arguments(1, listOf(Policy(1, 2, 'A') to "AB"), "uppercase"),
            arguments(1, listOf(Policy(2, 1, 'a') to "ab"), "b < a"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<Pair<Policy, String>>, name: String) {
            assertEquals(expected, Day02.partTwo(input))
        }

        @Suppress("unused")
        private fun `invalid inputs`() = listOf(
            arguments(listOf(Policy(0, 2, 'a') to "abc"), "a < 1"),
            arguments(listOf(Policy(1, 0, 'a') to "abc"), "b < 1"),
            arguments(listOf(Policy(10, 0, 'a') to ""), "a out of bounds"),
            arguments(listOf(Policy(1, 10, 'a') to ""), "b out of bounds"),
            arguments(listOf(Policy(1, 1, 'a') to "abc"), "a == b can never succeed"),
        )

        @ParameterizedTest(name = "{1}")
        @MethodSource
        fun `invalid inputs`(input: List<Int>, name: String) {
            assertThrows<IllegalArgumentException> {
                Day01.partTwo(input)
            }
        }
    }
}
