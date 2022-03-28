package de.fabianbonk.aoc2021

import de.fabianbonk.Exercise

object Day01 : Exercise<List<Int>>("Sonar Sweep") {
    override fun partOne(input: List<Int>) =
        input.fold(Int.MAX_VALUE to 0) { (prev, acc), v -> Pair(v, if (v > prev) acc + 1 else acc) }.second

    override fun partTwo(input: List<Int>): Int {
        var count = 0
        var prev = Int.MAX_VALUE
        for (i in 0..input.size - 3) {
            val sum = input[i] + input[i + 1] + input[i + 2]
            if (sum > prev) count++
            prev = sum
        }
        return count
    }
}
