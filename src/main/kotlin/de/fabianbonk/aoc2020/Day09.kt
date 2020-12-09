package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise

object Day09 : CustomExercise<Pair<List<Long>, Int>, Long>("Encoding Error") {
    override fun partOne(input: Pair<List<Long>, Int>): Long {
        val (numbers, preambleLength) = input

        for (i in preambleLength until numbers.size) {
            val preamble = numbers.subList(i - preambleLength, i)
            val valid = preamble.any {
                numbers[i] - it in preamble
            }

            if (!valid) return numbers[i]
        }

        throw IllegalArgumentException("All numbers are expressible as a sum of two preamble numbers.")
    }

    override fun partTwo(input: Pair<List<Long>, Int>): Long {
        val invalid = partOne(input)
        val numbers = input.first

        for (i in numbers.indices) {
            var acc = 0L
            for (j in i until numbers.size) {
                acc += numbers[j]
                if (acc > invalid) {
                    break
                }

                if (acc == invalid) {
                    val (min, max) =
                        numbers.subList(i, j).fold(Long.MAX_VALUE to Long.MIN_VALUE) { (min, max), n ->
                            min.coerceAtMost(n) to max.coerceAtLeast(n)
                        }
                    return min + max
                }
            }
        }

        throw IllegalArgumentException("$invalid is not expressible as a contiguous set.")
    }
}
