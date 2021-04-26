package de.fabianbonk.aoc2018

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : CustomTest<Day02, List<String>, String>("5928", "bqlporuexkwzyabnmgjqctvfs") {
    override val partOneInputs = listOf(
        arguments(
            "12",
            listOf(
                "abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab",
            ),
            "tutorial input 1"
        ),
    )

    override val partTwoInputs = listOf(
        arguments(
            "fgij",
            listOf(
                "abcde",
                "fghij",
                "klmno",
                "pqrst",
                "fguij",
                "axcye",
                "wvxyz",
            ),
            "tutorial input 1"
        ),
    )
}
