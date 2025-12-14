package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.TestConfig.SOLUTION_REPEAT_COUNT
import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class Day5Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(3, "day5", "example", Day5()::part1)
    }
    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 1 Solution`(){
        assertPartEquals(607, "day5", "input", Day5()::part1)
    }
    @Test fun `Part 2 Example`(){
        assertPartEquals(14, "day5", "example", Day5()::part2)
    }
    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 2 Solution`(){
        assertPartEquals(342433357244012, "day5", "input", Day5()::part2)
    }
}



