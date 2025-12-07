package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.Test

class Day2Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(1227775554, "day2", "example", Day2()::part1)
    }
    @Test fun `Part 1 Solution`(){
        assertPartEquals(34826702005, "day2", "input", Day2()::part1)
    }
    @Test fun `Part 2 Example`(){
        assertPartEquals(4174379265UL, "day2", "example", Day2()::part2)
    }
    @Test fun `Part 2 Solution`(){
        assertPartEquals(43287141963UL, "day2", "input", Day2()::part2)
    }
}



