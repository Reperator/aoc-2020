package de.fabianbonk.aoc2019

import de.fabianbonk.Exercise

object Day01 : Exercise<List<Int>>("The Tyranny of the Rocket Equation") {
    private fun fuelCost(mass: Int) = mass / 3 - 2

    override fun partOne(input: List<Int>) =
        input.sumBy(::fuelCost)

    private tailrec fun fuelCostRec(mass: Int, acc: Int = 0): Int {
        val cost = fuelCost(mass)
        return if (cost > 0) fuelCostRec(cost, acc + cost) else acc
    }

    override fun partTwo(input: List<Int>) =
        input.sumBy(::fuelCostRec)
}
