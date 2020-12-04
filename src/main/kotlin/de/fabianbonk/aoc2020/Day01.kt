package de.fabianbonk.aoc2020

object Day01 {
    fun partOne(input: List<Int>): Int {
        val nums = input.sorted()

        require(nums.size >= 2) { "at least two elements needed" }

        var lower = 0
        var upper = nums.size - 1

        while (lower < upper) {
            val sum = nums[lower] + nums[upper]

            when {
                sum == 2020 -> return nums[lower] * nums[upper]
                sum > 2020 -> upper--
                else -> lower++
            }
        }

        throw IllegalArgumentException("no two values sum to 2020")
    }

    fun partTwo(input: List<Int>): Int {
        val nums = input.sorted()

        require(nums.size >= 3) { "at least three elements needed" }

        // set for constant-time contains()
        // caution: we have to keep in mind that we might need the same value twice
        val numSet = nums.toSet()

        outer@ for (lower in 0 until (nums.size - 2)) {
            for (upper in (lower + 1) until (nums.size - 1)) {
                val sum = nums[lower] + nums[upper]

                if (sum >= 2020) {
                    // optimization:
                    // if sum already exceeds 2020, we can't find a third value anymore
                    // we can skip to the next lower value instead
                    break
                }

                val needed = 2020 - sum

                if (needed in numSet) {
                    if (nums[lower] == needed) {
                        // we need another `nums[lower]`:
                        // either `nums[upper] == nums[lower]` -> can't happen because 2020 isn't divisible by 3
                        // or `nums[upper] > nums[lower]` -> we have skipped past the other (non-existent) `nums[lower]`
                        break@outer
                    }
                    // either we need `nums[upper]` and something to the right of `upper`
                    // or we need two `nums[upper]` (the second one is at `upper + 1` due to sorting)
                    if (nums[upper] != needed || nums[upper + 1] == needed) {
                        return nums[lower] * nums[upper] * needed
                    }
                }
            }
        }

        throw IllegalArgumentException("no three values sum to 2020")
    }
}
