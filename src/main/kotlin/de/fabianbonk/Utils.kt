package de.fabianbonk

/**
 * Apply [block] to [this] [times] times.
 */
inline fun <T> T.iterate(times: Int, block: (T) -> T): T {
    var current = this
    for (i in 0 until times) {
        current = block(current)
    }
    return current
}
