package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day9Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(50L, "day9", "example", Day9()::part1)
    }

    @Test fun `Part 1 Solution`(){
        assertPartEquals(4758121828L, "day9", "input", Day9()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(24L, "day9", "example", Day9()::part2)
    }

//    @Test fun `Part 2 Solution`(){
//        assertPartEquals(0L, "day9", "input", Day9()::part2)
//    }
    @Test fun `Part 2 U-Shape`(){
        assertPartEquals(6L, "day9", "u-shape", Day9()::part2)
    }
    @Test fun `Part 2 T-Shape`(){
        assertPartEquals(66L, "day9", "t-shape", Day9()::part2)
    }
}



