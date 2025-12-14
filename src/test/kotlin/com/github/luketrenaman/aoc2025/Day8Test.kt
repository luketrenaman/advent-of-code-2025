package com.github.luketrenaman.aoc2025

import com.github.luketrenaman.aoc2025.util.TestConfig.SOLUTION_REPEAT_COUNT
import com.github.luketrenaman.aoc2025.util.assertPartEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class Day8Test {
    @Test fun `Part 1 Example`(){
        assertPartEquals(40L, "day8", "example", Day8()::part1)
    }

    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 1 Solution`(){
        assertPartEquals(32103L, "day8", "input", Day8()::part1)
    }

    @Test fun `Part 2 Example`(){
        assertPartEquals(25272L, "day8", "example", Day8()::part2)
    }

    @RepeatedTest(SOLUTION_REPEAT_COUNT) fun `Part 2 Solution`(){
        assertPartEquals(8133642976L, "day8", "input", Day8()::part2)
    }
}



