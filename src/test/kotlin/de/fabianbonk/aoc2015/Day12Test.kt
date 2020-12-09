package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day12Test : Test<Day12, String>(119433, 68466, { this }) {
    override val partOneInputs = listOf(
        arguments(6, "[1,2,3]", "tutorial input 1"),
        arguments(6, """{"a":2,"b":4}""", "tutorial input 2"),
        arguments(3, "[[[3]]]", "tutorial input 3"),
        arguments(3, """{"a":{"b":4},"c":-1}""", "tutorial input 4"),
        arguments(0, """{"a":[-1,1]}""", "tutorial input 5"),
        arguments(0, """[-1,{"a":1}]""", "tutorial input 6"),
        arguments(0, "[]", "tutorial input 7"),
        arguments(0, "{}", "tutorial input 8"),
    )

    override val partTwoInputs = listOf(
        arguments(6, "[1,2,3]", "tutorial input 1"),
        arguments(4, """[1,{"c":"red","b":2},3]""", "tutorial input 2"),
        arguments(0, """{"d":"red","e":[1,2,3,4],"f":5}""", "tutorial input 3"),
        arguments(6, """[1,"red",5]""", "tutorial input 4")
    )
}
