package de.fabianbonk.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("2015/05: Doesn't He Have Intern-Elves For This?")
@Suppress("unused", "UNUSED_PARAMETER")
class Day05Test {
    private val reference = javaClass
        .getResource("/2015/input-05.txt")
        .readText()
        .trim()
        .lines()

    @Nested
    inner class PartOne {
        private fun `valid inputs`() = listOf(
            arguments(1, listOf("ugknbfddgicrmopn"), "tutorial input 1"),
            arguments(1, listOf("aaa"), "tutorial input 2"),
            arguments(0, listOf("jchzalrnumimnmhp"), "tutorial input 3"),
            arguments(0, listOf("haegwjzuvuyypxyu"), "tutorial input 4"),
            arguments(0, listOf("dvszwmarrgswjxmb"), "tutorial input 5"),
            arguments(258, reference, "reference input"),
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
            arguments(1, listOf("qjhvhtzxzqqjkmpb"), "tutorial input 1"),
            arguments(1, listOf("xxyxx"), "tutorial input 2"),
            arguments(0, listOf("uurcxstgmygtbstg"), "tutorial input 3"),
            arguments(0, listOf("ieodomkazucvgmuy"), "tutorial input 4"),
            arguments(0, listOf("cabaaa", "caaaba", "abaaa", "aaaba"), "don't accept overlaps"),
            arguments(53, reference, "reference input"),
        )

        @ParameterizedTest(name = "{2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: List<String>, name: String) {
            assertEquals(expected, Day05.partTwo(input))
        }
    }
}
