package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day07Test : Test<Day07, List<String>>(246, 2976) {
    override val partOneInputs = listOf(
        arguments(
            4,
            listOf(
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags.",
            ),
            "tutorial input"
        ),
        arguments(
            0,
            listOf(
                "blue bags contain 1 yellow bag.",
                "yellow bags contain 1 blue bag.",
            ),
            "circular reference"
        ),
        arguments(
            1,
            listOf(
                "shiny gold bags contain 1 dark olive bag.",
                "dark olive bags contain 1 shiny gold bag.",
            ),
            "shiny gold in shiny gold"
        ),
        arguments(
            1,
            listOf("dark olive bags contain 1 bright white bag, 1 shiny gold bag, 1 light gray bag."),
            ">2 inner bags"
        ),
    )

    override val partTwoInputs = listOf(
        arguments(
            126,
            listOf(
                "shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags.",
            ),
            "tutorial input"
        )
    )
}
