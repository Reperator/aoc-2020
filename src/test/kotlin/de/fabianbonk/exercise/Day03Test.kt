package de.fabianbonk.exercise

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Day 03: Toboggan Trajectory")
class Day03Test {
    private val tutorial = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().trim().let(::Forest)

    private val reference = javaClass
        .getResource("/input-03.txt")
        .readText()
        .trim()
        .let(::Forest)

    @Nested
    inner class PartOne {
        private val slope = Slope(3, 1)

        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(7, tutorial, slope, "tutorial input"),
            arguments(169, reference, slope, "reference input"),
        )

        @ParameterizedTest(name = "{3}")
        @MethodSource
        fun `valid inputs`(expected: Int, forest: Forest, slope: Slope, name: String) {
            assertEquals(expected, Day03.partOne(forest, slope))
        }
    }

    @Nested
    inner class PartTwo {
        private val slopes = listOf(
            Slope(1, 1),
            Slope(3, 1),
            Slope(5, 1),
            Slope(7, 1),
            Slope(1, 2),
        )

        @Suppress("unused")
        private fun `valid inputs`() = listOf(
            arguments(336L, tutorial, slopes, "tutorial input"),
            arguments(7560370818L, reference, slopes, "reference input"),
        )

        @ParameterizedTest(name = "{3}")
        @MethodSource
        fun `valid inputs`(expected: Long, forest: Forest, slopes: List<Slope>, name: String) {
            assertEquals(expected, Day03.partTwo(forest, slopes))
        }
    }
}
