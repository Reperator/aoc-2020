package de.fabianbonk.aoc2021

import de.fabianbonk.Exercise
import de.fabianbonk.toInt

object Day03 : Exercise<List<String>>("Binary Diagnostic") {
    override fun partOne(input: List<String>): Int {
        require(input.isNotEmpty())

        val counts = Array(input.first().length) { 0 }

        for (v in input) {
            for ((index, bit) in v.withIndex()) {
                if (bit == '1') {
                    counts[index]++
                }
            }
        }

        // Slightly unclear definition of "most common"; assuming strictly more 1s than 0s or vice versa.
        val gamma = counts.map { it > input.size / 2 }.toInt()
        val epsilon = counts.map { it < input.size / 2 }.toInt()

        return gamma * epsilon
    }

    override fun partTwo(input: List<String>): Int {
        var oxygen = input
        var index = 0
        while (oxygen.size > 1) {
            oxygen =
                oxygen.filter { it[index] == if (oxygen.count { it[index] == '0' } > oxygen.size / 2) '0' else '1' }
            index++
        }

        var co2 = input
        index = 0
        while (co2.size > 1) {
            // Always round up.
            co2 = co2.filter { it[index] == if (co2.count { it[index] == '1' } < (co2.size + 1) / 2) '1' else '0' }
            index++
        }

        return oxygen.first().map { it == '1' }.toInt() * co2.first().map { it == '1' }.toInt()
    }
}
