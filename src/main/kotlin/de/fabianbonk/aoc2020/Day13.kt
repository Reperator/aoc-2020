package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise

object Day13 : CustomExercise<Pair<Int, List<String>>, Long>("Shuttle Search") {
    override fun partOne(input: Pair<Int, List<String>>) =
        input.second.mapNotNull {
            if (it == "x") {
                null
            } else {
                val bus = it.toLong()
                val wait = bus - (input.first % bus)
                bus to wait
            }
        }.minByOrNull {
            it.second
        }?.let { (bus, wait) ->
            bus * wait
        } ?: throw IllegalArgumentException("no buses found")

    override fun partTwo(input: Pair<Int, List<String>>): Long {
        val buses = input.second.mapIndexedNotNull { i, bus ->
            if (bus == "x") {
                null
            } else {
                val b = bus.toLong()
                b to ((i * b) - i) % b
            }
        }.toMutableSet()

        var (step, t) = buses.maxByOrNull {
            it.first
        }?.also {
            buses.remove(it)
        } ?: return 0L

        while (t >= 0) {
            buses.filter { (bus, i) ->
                t % bus == i
            }.forEach {
                // separate loop to prevent ConcurrentModificationException
                buses.remove(it)
                // all buses are prime numbers, no need to check if bus is already a factor of step
                step *= it.first
            }

            if (buses.isEmpty()) {
                return t
            }

            t += step
        }

        throw IllegalArgumentException("no candidate t found")
    }
}
