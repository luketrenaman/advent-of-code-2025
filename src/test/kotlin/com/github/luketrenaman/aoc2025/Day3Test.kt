package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day3Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(357, "day3", "example", Day3()::part1)
    }
    @Test fun `Part 1 Solution`(){
        assertPartEquals(16858, "day3", "input", Day3()::part1)
    }
    @Test fun `Part 2 Example`(){
        assertPartEquals(3121910778619, "day3", "example", Day3()::part2)
    }
    @Test fun `Part 2 Solution`(){
        assertPartEquals(167549941654721, "day3", "input", Day3()::part2)
    }
}



