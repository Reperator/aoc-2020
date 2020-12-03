package de.fabianbonk.exercise

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.Integer.parseInt

@DisplayName("Day 01: Report Repair")
class Day01Test {
    private val tutorial = listOf(
        1721,
        979,
        366,
        299,
        675,
        1456
    )

    private val reference = javaClass
        .getResource("/input-01.txt")
        .readText()
        .trim()
        .lines()
        .map(::parseInt)

    @Nested
    @DisplayName("Part One")
    inner class PartOne {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(514579, tutorial, "tutorial input"),
            arguments(539851, reference, "reference input"),
            arguments(40000, listOf(20, 2000, 20, 2000), "duplicate numbers"),
            arguments(2019, listOf(1, 2019), "only two numbers"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<Int>, name: String) {
            assertEquals(expected, Day01.partOne(input))
        }

        @Suppress("unused")
        private fun `invalid inputs`() = listOf(
            arguments(emptyList<Int>(), "not enough elements (0)"),
            arguments(listOf(1), "not enough elements (1)"),
            arguments(listOf(1, 2), "small elements"),
            arguments(listOf(100000, 200000), "large elements"),
            arguments(listOf(1, 200000), "small and large elements"),
        )

        @ParameterizedTest(name = "{1}")
        @MethodSource
        fun `invalid inputs`(input: List<Int>, name: String) {
            assertThrows<IllegalArgumentException> {
                Day01.partOne(input)
            }
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class PartTwo {
        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(241861950, tutorial, "tutorial input"),
            arguments(212481360, reference, "reference input"),
            arguments(200000, listOf(10, 11, 2000, 10, 100, 2000), "duplicate numbers"),
            arguments(2018, listOf(2018, 1, 1), "only three numbers"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<Int>, name: String) {
            assertEquals(expected, Day01.partTwo(input))
        }

        @Suppress("unused")
        private fun `invalid inputs`() = listOf(
            arguments(emptyList<Int>(), "not enough elements (0)"),
            arguments(listOf(1), "not enough elements (1)"),
            arguments(listOf(1, 2), "not enough elements (2)"),
            arguments(listOf(1, 2, 3), "small elements"),
            arguments(listOf(100000, 200000, 300000), "large elements"),
            arguments(listOf(1, 200000, 3), "small and large elements"),
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
