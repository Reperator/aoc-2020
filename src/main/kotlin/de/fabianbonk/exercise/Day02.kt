package de.fabianbonk.exercise

data class Policy(
    val a: Int,
    val b: Int,
    val letter: Char,
) {
    fun isValidForSledRental(password: String): Boolean {
        require(a >= 0) { "a must be >= 0" }
        require(b >= a) { "b must be >= a" }

        return password.count { it == letter } in a..b
    }

    fun isValidForTobogganRental(password: String): Boolean {
        require(a >= 1) { "a must be >= 1" }
        require(b >= 1) { "b must be >= 1" }
        require(a != b) { "a must not equal b" }

        try {
            return (password[a - 1] == letter) xor (password[b - 1] == letter)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalArgumentException("password too short")
        }
    }

    companion object {
        fun ofString(input: String): Policy {
            val (min, max, letter) = """(\d+)-(\d+) (\p{Lower}|\p{Upper})""".toRegex().find(input)?.destructured
                ?: throw IllegalArgumentException("Policy must match '<min>-<max> <char>' pattern")

            return Policy(min.toInt(), max.toInt(), letter[0])
        }
    }
}

object Day02 {
    fun partOne(input: List<Pair<Policy, String>>): Int =
        input.count { (policy, password) ->
            policy.isValidForSledRental(password)
        }

    fun partTwo(input: List<Pair<Policy, String>>): Int =
        input.count { (policy, password) ->
            policy.isValidForTobogganRental(password)
        }
}
