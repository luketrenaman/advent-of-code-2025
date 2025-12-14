package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.TestConfig.SOLUTION_REPEAT_COUNT
import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class Day4Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(13, "day4", "example", Day4()::part1)
    }
    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 1 Solution`(){
        assertPartEquals(1537, "day4", "input", Day4()::part1)
    }
    @Test fun `Part 2 Example`(){
        assertPartEquals(43, "day4", "example", Day4()::part2)
    }
    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 2 Solution`(){
        assertPartEquals(8707, "day4", "input", Day4()::part2)
    }
    @Test fun `Part 2 Optimized Example`(){
        assertPartEquals(43, "day4", "example", Day4()::part2Optimized)
    }
    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 2 Optimized Solution`(){
        assertPartEquals(8707, "day4", "input", Day4()::part2Optimized)
    }
}



