package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise
import kotlin.math.min

data class Edge(
    val from: String,
    val to: String,
    val distance: Int
) {
    companion object {
        fun ofString(input: String): List<Edge> {
            val (from, to, distance) = """(\p{Alpha}+) to (\p{Alpha}+) = (\d+)""".toRegex().find(input)?.destructured
                ?: throw IllegalArgumentException("route must match '<from> to <to> = <distance>'")
            return listOf(Edge(from, to, distance.toInt()), Edge(to, from, distance.toInt()))
        }
    }
}

object Day09 : Exercise<List<String>>("All in a Single Night") {
    private fun findMin(edges: Map<String, Set<Edge>>) =
        edges.keys.let { locations ->
            // travelling salesman is NP-hard :(
            fun minRouteFrom(
                start: String,
                toVisit: Set<String> = locations - start,
                dist: Int = 0,
                min: Int = Int.MAX_VALUE,
            ): Int =
                if (toVisit.isEmpty()) {
                    min(min, dist)
                } else {
                    edges[start]?.mapNotNull {
                        if (it.to in toVisit) {
                            minRouteFrom(it.to, toVisit - it.to, dist + it.distance, min)
                        } else {
                            null
                        }
                    }?.minOrNull() ?: min
                }

            locations.map {
                minRouteFrom(it)
            }.minOrNull() ?: throw IllegalArgumentException("at least one route is required")
        }

    private fun parseEdges(input: List<String>): Map<String, Set<Edge>> =
        input.flatMap {
            Edge.ofString(it)
        }.fold(emptyMap()) { acc, edge ->
            val current = acc[edge.from]
            if (current == null) {
                acc + (edge.from to setOf(edge))
            } else {
                acc + (edge.from to (current + edge))
            }
        }

    override fun partOne(input: List<String>) =
        findMin(parseEdges(input))

    override fun partTwo(input: List<String>) =
        parseEdges(input).mapValues { (_, edges) ->
            edges.map { it.copy(distance = -it.distance) }.toSet()
        }.let { inverted ->
            -findMin(inverted)
        }
}
