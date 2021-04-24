package de.fabianbonk.aoc2017

import de.fabianbonk.Exercise

object Day01 : Exercise<List<Int>>("Inverse Captcha") {
    override fun partOne(input: List<Int>) =
        input.foldIndexed(0) { i, acc, n ->
            if (n == input[(i + 1) % input.size]) acc + n else acc
        }

    override fun partTwo(input: List<Int>) =
        input.foldIndexed(0) { i, acc, n ->
            if (n == input[(i + (input.size / 2)) % input.size]) acc + n else acc
        }
}
