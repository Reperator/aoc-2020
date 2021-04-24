package de.fabianbonk.aoc2018

import de.fabianbonk.Exercise

object Day01 : Exercise<List<Int>>("Chronal Calibration") {
    override fun partOne(input: List<Int>) = input.sum()

    override fun partTwo(input: List<Int>): Int {
        val seen = mutableSetOf<Int>()
        var freq = 0
        var index = 0

        while (freq !in seen) {
            seen += freq
            freq += input[index]
            index = (index + 1) % input.size
        }

        return freq
    }
}
