package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(3, "day1", "example", Day1()::part1)
    }
    @Test fun `Part 1 Solution`(){
        assertPartEquals(1066, "day1", "input", Day1()::part1)
    }
    @Test fun `Part 2 Example`(){
        assertPartEquals(6, "day1", "example", Day1()::part2)
    }
    @Test fun `Part 2 Solution`(){
        assertPartEquals(6223, "day1", "input", Day1()::part2)
    }
    @Test fun `Part 2 Optimized Example`(){
        assertPartEquals(6, "day1", "example", Day1()::part2Optimized)
    }
    @Test fun `Part 2 Optimized Solution`(){
        assertPartEquals(6223, "day1", "input", Day1()::part2Optimized)
    }
}