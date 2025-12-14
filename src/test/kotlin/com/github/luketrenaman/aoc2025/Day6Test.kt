package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.TestConfig.SOLUTION_REPEAT_COUNT
import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class Day6Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(4277556L, "day6", "example", Day6()::part1)
    }

    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 1 Solution`(){
        assertPartEquals(5227286044585L, "day6", "input", Day6()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(3263827L, "day6", "example", Day6()::part2)
    }

    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 2 Solution`(){
        assertPartEquals(10227753257799L, "day6", "input", Day6()::part2)
    }
}