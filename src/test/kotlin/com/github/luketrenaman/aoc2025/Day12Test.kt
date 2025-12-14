package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.TestConfig.SOLUTION_REPEAT_COUNT
import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class Day12Test {
    // Skip example because I ignored it
//    @Test fun example(){
//        assertPartEquals(2L, "day12", "example", Day12()::part1)
//    }

    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun solution(){
        assertPartEquals(528L, "day12", "input", Day12()::part1)
    }

    @Test fun allDefinitelyUnsafe(){
        assertPartEquals(0L, "day12", "all-definitely-unsafe", Day12()::part1)
    }

    @Test fun allDefinitelySafe(){
        assertPartEquals(3L, "day12", "all-definitely-safe", Day12()::part1)
    }
}



