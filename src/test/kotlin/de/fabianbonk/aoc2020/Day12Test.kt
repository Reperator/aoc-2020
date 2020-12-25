package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import de.fabianbonk.iterate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.EnumSource

class Day12Test : Test<Day12, List<String>>(319, 50157) {
    override val partOneInputs = listOf(
        arguments(25, listOf("F10", "N3", "F7", "R90", "F11"), "tutorial input")
    )

    override val partTwoInputs = listOf(
        arguments(286, listOf("F10", "N3", "F7", "R90", "F11"), "tutorial input")
    )

    @ParameterizedTest
    @EnumSource(value = Dir::class)
    fun `Cardinal Directions`(dir: Dir) {
        for (i in 1 until 4) {
            assertNotEquals(dir, dir.iterate(i) { it.turn(true) })
            assertNotEquals(dir, dir.iterate(i) { it.turn(false) })
        }
        assertEquals(dir, dir.iterate(4) { it.turn(true) })
        assertEquals(dir, dir.iterate(4) { it.turn(false) })
    }
}
