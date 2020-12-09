package de.fabianbonk.aoc2015

import de.fabianbonk.CustomExercise

object Day11 : CustomExercise<String, String>("Corporate Policy") {
    private fun CharArray.next() {
        var carry = true

        for (i in size - 1 downTo 0) {
            if (carry) {
                carry = this[i]++ == 'z'
                if (carry) {
                    this[i] = 'a'
                }
            }
        }
    }

    private inline val CharArray.isValid: Boolean
        get() {
            if ('i' in this || 'o' in this || 'l' in this) {
                return false
            }

            (0 until size - 2).find { i ->
                this[i] + 1 == this[i + 1] && this[i + 1] + 1 == this[i + 2]
            } ?: return false

            return (0 until size - 1).find { i ->
                this[i] == this[i + 1]
            }?.let { prev ->
                (prev + 1 until size - 1).any { i ->
                    this[i] == this[i + 1] && this[i] != this[prev]
                }
            } ?: false
        }

    override fun partOne(input: String): String {
        val chars = input.toCharArray()

        while (!chars.isValid) {
            chars.next()
        }

        return String(chars)
    }

    override fun partTwo(input: String) = partOne(input)
}
