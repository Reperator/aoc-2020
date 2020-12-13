package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

enum class Cell {
    Floor, Empty, Occupied;

    companion object {
        fun parse(input: Char) =
            when (input) {
                '.' -> Floor
                'L' -> Empty
                '#' -> Occupied
                else -> throw IllegalArgumentException("Unknown cell state $input")
            }
    }
}

private typealias Board = Array<Array<Cell>>

object Day11 : Exercise<List<List<Cell>>>("Seating System") {
    /**
     * Performance-optimized fixed point iteration.
     */
    private fun fixedPoint(input: List<List<Cell>>, f: (Int, Int, Board) -> Cell): Int {
        tailrec fun iterate(current: Board, next: Board): Board {
            for (row in current.indices) {
                for (col in current[row].indices) {
                    next[row][col] = f(row, col, current)
                }
            }

            return if (next.contentDeepEquals(current)) {
                // swap the buffers
                current
            } else {
                iterate(next, current)
            }
        }

        return iterate(
            input.map { it.toTypedArray() }.toTypedArray(),
            Array(input.size) { Array(input[it].size) { Cell.Floor } },
        ).sumBy { row ->
            row.count { it == Cell.Occupied }
        }
    }

    // Array seems to be faster than List or Set
    private val neighbors = arrayOf(
        -1 to -1,
        -1 to 0,
        -1 to 1,
        0 to -1,
        0 to 1,
        1 to -1,
        1 to 0,
        1 to 1,
    )

    override fun partOne(input: List<List<Cell>>) =
        fixedPoint(input) { row, col, board ->
            fun occupiedNeighbors() = neighbors.count { (dx, dy) ->
                val x = row + dx
                val y = col + dy
                x in board.indices && y in board[x].indices && board[x][y] == Cell.Occupied
            }

            when (board[row][col]) {
                Cell.Floor -> Cell.Floor
                Cell.Empty -> if (occupiedNeighbors() == 0) Cell.Occupied else Cell.Empty
                Cell.Occupied -> if (occupiedNeighbors() >= 4) Cell.Empty else Cell.Occupied
            }
        }

    override fun partTwo(input: List<List<Cell>>) =
        fixedPoint(input) { row: Int, col: Int, board: Board ->
            fun occupiedNeighbors() = neighbors.count { (dx, dy) ->
                tailrec fun check(x: Int, y: Int): Boolean =
                    if (x in board.indices && y in board[row].indices) {
                        when (board[x][y]) {
                            Cell.Occupied -> true
                            Cell.Empty -> false
                            Cell.Floor -> check(x + dx, y + dy)
                        }
                    } else {
                        false
                    }

                check(row + dx, col + dy)
            }

            when (board[row][col]) {
                Cell.Floor -> Cell.Floor
                Cell.Empty -> if (occupiedNeighbors() == 0) Cell.Occupied else Cell.Empty
                Cell.Occupied -> if (occupiedNeighbors() >= 5) Cell.Empty else Cell.Occupied
            }
        }
}
