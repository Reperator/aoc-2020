package de.fabianbonk.aoc2015

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import de.fabianbonk.Exercise

object Day12 : Exercise<String>("JSAbacusFramework.io") {
    private fun countAll(json: JsonNode): Int =
        when {
            json.canConvertToInt() -> json.asInt()
            json.isArray -> json.sumBy { countAll(it) }
            json.isObject -> json.sumBy { countAll(it) }
            json.isTextual -> 0
            else -> throw IllegalArgumentException("Unexpected JSON node $json")
        }

    override fun partOne(input: String) =
        countAll(ObjectMapper().readTree(input))

    private fun JsonNode.hasRed(): Boolean =
        isObject && any {
            (it.isTextual && it.toString() == "\"red\"")
        }

    private fun countWithoutRed(json: JsonNode): Int =
        when {
            json.canConvertToInt() -> json.asInt()
            json.isArray -> json.sumBy { countWithoutRed(it) }
            json.isObject -> {
                if (json.any { (it.toString() == "\"red\"") }) {
                    0
                } else {
                    json.sumBy { countWithoutRed(it) }
                }
            }
            json.isTextual -> 0
            else -> throw IllegalArgumentException("Unexpected JSON node $json")
        }

    override fun partTwo(input: String) =
        countWithoutRed(ObjectMapper().readTree(input))
}
