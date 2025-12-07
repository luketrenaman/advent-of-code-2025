package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day7Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(21, "day7", "example", Day7()::part1)
    }

    @Test fun `Part 1 Solution`(){
        assertPartEquals(1656, "day7", "input", Day7()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(40L, "day7", "example", Day7()::part2)
    }

    @Test fun `Part 2 Solution`(){
        assertPartEquals(76624086587804L, "day7", "input", Day7()::part2)
    }
}