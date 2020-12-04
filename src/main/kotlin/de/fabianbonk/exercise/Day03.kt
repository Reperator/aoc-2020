package de.fabianbonk.exercise

sealed class Square {
    override fun toString() =
        when (this) {
            OPEN -> "."
            TREE -> "#"
        }
}

object OPEN : Square()

object TREE : Square()

class Forest(
    input: String,
) {
    private val forest: List<List<Square>>

    private val height: Int

    private val width: Int

    init {
        val lines = input.lines()

        require(lines.isNotEmpty()) { "there must be at least one line" }
        require(lines.all { it.length == lines[0].length }) { "all lines must have the same length" }

        height = lines.size

        width = lines[0].length

        forest = lines.map { line ->
            line.map { square ->
                when (square) {
                    '.' -> OPEN
                    '#' -> TREE
                    else -> throw IllegalArgumentException("unexpected character: $square")
                }
            }
        }
    }

    fun traverse(slope: Slope) =
        // [0, 0] is not checked in the example; we should start at [right, down]
        (slope.down until height step slope.down).fold(
            Pair(slope.right % width, 0)
        ) { (x, trees), y ->
            Pair((x + slope.right) % width, trees + if (forest[y][x] == TREE) 1 else 0)
        }.second

    override fun toString() =
        forest.joinToString(separator = "\n") {
            it.joinToString(separator = "")
        }
}

data class Slope(
    val right: Int,
    val down: Int,
) {
    init {
        require(down > 0) { "slope must go down" }
    }
}

object Day03 {
    fun partOne(forest: Forest, slope: Slope): Int =
        forest.traverse(slope)

    fun partTwo(forest: Forest, slopes: List<Slope>) =
        slopes.fold(1L) { acc, slope ->
            acc * forest.traverse(slope)
        }
}
