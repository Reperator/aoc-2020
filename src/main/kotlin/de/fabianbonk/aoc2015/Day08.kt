package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

object Day08 : Exercise<List<String>>("Matchsticks") {
    override fun partOne(input: List<String>) =
        input.sumBy { string ->
            val charLen = string.length
            var cur = 0
            var count = -2
            while (cur < string.length) {
                if (string[cur] == '\\') {
                    cur += if (string[cur + 1] == 'x') 4 else 2
                } else {
                    cur++
                }
                count++
            }
            charLen - count
        }

    override fun partTwo(input: List<String>) =
        input.sumBy { string ->
            string.sumBy {
                when (it) {
                    '"', '\\' -> 2
                    else -> 1
                }
            } + 2 - string.length
        }
}
