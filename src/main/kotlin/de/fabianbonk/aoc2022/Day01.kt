package de.fabianbonk.aoc2022

import de.fabianbonk.Exercise

object Day01 : Exercise<List<List<Int>>>("Calorie Counting") {
    override fun partOne(input: List<List<Int>>) = input.maxOf { it.sum() }

    override fun partTwo(input: List<List<Int>>) = input.map { it.sum() }.sortedDescending().take(3).sum()
}
