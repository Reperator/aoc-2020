package de.fabianbonk.aoc2017

import de.fabianbonk.Exercise

object Day02 : Exercise<List<List<Int>>>("Corruption Checksum") {
    override fun partOne(input: List<List<Int>>) =
        input.sumBy {
            it.maxOrNull()!! - it.minOrNull()!!
        }

    override fun partTwo(input: List<List<Int>>) =
        input.sumBy { line ->
            for (i in line) {
                for (j in line) {
                    if ((i / j) * j == i && i != j) {
                        return@sumBy i / j
                    }
                }
            }

            throw IllegalArgumentException("No evenly divisible values in input.")
        }
}
