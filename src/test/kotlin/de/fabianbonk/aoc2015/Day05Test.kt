package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day05Test : Test<Day05, List<String>>(258, 53) {
    override val partOneInputs = listOf(
        arguments(1, listOf("ugknbfddgicrmopn"), "tutorial input 1"),
        arguments(1, listOf("aaa"), "tutorial input 2"),
        arguments(0, listOf("jchzalrnumimnmhp"), "tutorial input 3"),
        arguments(0, listOf("haegwjzuvuyypxyu"), "tutorial input 4"),
        arguments(0, listOf("dvszwmarrgswjxmb"), "tutorial input 5"),
    )

    override val partTwoInputs = listOf(
        arguments(1, listOf("qjhvhtzxzqqjkmpb"), "tutorial input 1"),
        arguments(1, listOf("xxyxx"), "tutorial input 2"),
        arguments(0, listOf("uurcxstgmygtbstg"), "tutorial input 3"),
        arguments(0, listOf("ieodomkazucvgmuy"), "tutorial input 4"),
        arguments(0, listOf("cabaaa", "caaaba", "abaaa", "aaaba"), "don't accept overlaps"),
    )
}
