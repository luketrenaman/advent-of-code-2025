package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day12Test {
    @Test fun example(){
        assertPartEquals(2L, "day12", "example", Day12()::part1)
    }

    @Test fun solution(){
        assertPartEquals(0L, "day12", "input", Day12()::part1)
    }

    @Test fun allDefinitelyUnsafe(){
        assertPartEquals(0L, "day12", "all-definitely-unsafe", Day12()::part1)
    }

    @Test fun allDefinitelySafe(){
        assertPartEquals(3L, "day12", "all-definitely-safe", Day12()::part1)
    }
}



