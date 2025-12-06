package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day7Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            0L,
            Day7().part1(File("src/test/resources/day7/example.txt"))
        )
    }

    @Test fun `Part 1 Solution`(){
        assertEquals(
            0L,
            Day7().part1(File("src/test/resources/day7/input.txt"))
        )
    }

    @Test fun `Part 2 Example`(){
        assertEquals(
            0L,
            Day7().part2(File("src/test/resources/day7/example.txt"))
        )
    }

    @Test fun `Part 2 Solution`(){
        assertEquals(
            0L,
            Day7().part2(File("src/test/resources/day7/input.txt"))
        )
    }
}