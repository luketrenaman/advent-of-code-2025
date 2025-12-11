package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day11Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(5L, "day11", "example", Day11()::part1)
    }

    @Test fun `Part 1 Solution`(){
        assertPartEquals(634L, "day11", "input", Day11()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(2L, "day11", "example-2", Day11()::part2)
    }

    @Test fun `Part 2 Solution`(){
        assertPartEquals(0L, "day11", "input", Day11()::part2)
    }
    @Test fun `Part 2 Example 8 paths`(){
        assertPartEquals(8L, "day11", "example-8-paths", Day11()::part2)
    }
    @Test fun `Part 2 Example 6 paths`(){
        assertPartEquals(6L, "day11", "example-6-topology", Day11()::part2)
    }
    @Test fun `Part 2 Example 3 paths`(){
        assertPartEquals(3L, "day11", "example-3-paths", Day11()::part2)
    }
    @Test fun `Part 2 Example racing branches`(){
        assertPartEquals(2L, "day11", "example-racing-branches", Day11()::part2)
    }
}



