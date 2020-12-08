package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day10Test : Test<Day10, Pair<String, Int>>(492982, 6989950) {
    private val ref = "1321131112"

    override val reference = ref to 40

    override val referencePartTwo = ref to 50

    override val partOneInputs = listOf(
        arguments("11".length, "1" to 1, "tutorial input 1"),
        arguments("21".length, "11" to 1, "tutorial input 2"),
        arguments("1211".length, "21" to 1, "tutorial input 3"),
        arguments("111221".length, "1211" to 1, "tutorial input 4"),
        arguments("312211".length, "111221" to 1, "tutorial input 5"),
    )
}
