package de.fabianbonk.exercise

object Day01 {
    fun partOne(input: List<Int>): Int {
        val nums = input.sorted()

        if (nums.size < 2) {
            throw IllegalArgumentException("at least two elements needed")
        }

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

        if (nums.size < 3) {
            throw IllegalArgumentException("at least three elements needed")
        }

        var lower = 0
        var upper = 1

        while (lower < nums.size - 2) {
            val sum = nums[lower] + nums[upper]

            val needed = 2020 - sum

            if (nums.binarySearch(needed, upper + 1) >= 0) {
                return nums[lower] * nums[upper] * needed
            }

            if (upper == nums.size - 2) {
                lower++
                upper = lower + 1
            } else {
                upper++
            }
        }

        throw IllegalArgumentException("no three values sum to 2020")
    }
}
