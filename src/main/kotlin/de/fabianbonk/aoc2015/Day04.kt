package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise
import java.security.MessageDigest
import kotlin.experimental.and

object Day04 : Exercise<String>("The Ideal Stocking Stuffer") {
    private inline fun bruteForce(input: String, validate: (ByteArray) -> Boolean): Int {
        val key = input.toByteArray()
        val md5 = MessageDigest.getInstance("MD5")
        for (current in 0..Int.MAX_VALUE) {
            val digest = md5.run {
                reset()
                update(key)
                update(current.toString().toByteArray())
                digest()
            }
            if (validate(digest)) {
                return current
            }
        }

        throw IllegalArgumentException("no valid nonce found in 0..${Int.MAX_VALUE}")
    }

    override fun partOne(input: String) =
        bruteForce(input) {
            it[0] == 0.toByte() && it[1] == 0.toByte() && it[2].and(0xf0.toByte()) == 0.toByte()
        }

    override fun partTwo(input: String) =
        bruteForce(input) {
            it[0] == 0.toByte() && it[1] == 0.toByte() && it[2] == 0.toByte()
        }
}
