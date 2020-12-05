package de.fabianbonk.aoc2015

object Day05 {
    fun partOne(input: List<String>) =
        input.count { word ->
            val hasVowels = word.count { it in "aeiou" } >= 3

            val hasDuplicates = (0 until word.length - 1).any { i -> word[i] == word[i + 1] }

            val noBadStrings = !setOf("ab", "cd", "pq", "xy").any { it in word }

            hasVowels && hasDuplicates && noBadStrings
        }

    fun partTwo(input: List<String>) =
        input.count { word ->
            val hasPair = (0 until word.length - 1).any { i ->
                // allocates two strings; could be done without allocations
                "${word[i]}${word[i + 1]}" in word.substring(i + 2)
            }

            val hasRepeat = (0 until word.length - 2).any { i ->
                word[i] == word[i + 2] && word[i] != word[i + 1]
            }

            hasPair && hasRepeat
        }
}
