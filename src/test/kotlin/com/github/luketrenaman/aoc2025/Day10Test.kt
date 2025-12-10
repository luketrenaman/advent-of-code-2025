package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day10Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(7L, "day10", "example", Day10()::part1)
    }

    @Test fun `Part 1 Solution`(){
        assertPartEquals(530L, "day10", "input", Day10()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(33L, "day10", "example", Day10()::part2)
    }
    @Test fun `Part 2 Solution`(){
        assertPartEquals(20172L, "day10", "input", Day10()::part2)
    }
}



