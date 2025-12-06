package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day11Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            0L,
            Day11().part1(File("src/test/resources/day11/example.txt"))
        )
    }

    @Test fun `Part 1 Solution`(){
        assertEquals(
            0L,
            Day11().part1(File("src/test/resources/day11/input.txt"))
        )
    }

    @Test fun `Part 2 Example`(){
        assertEquals(
            0L,
            Day11().part2(File("src/test/resources/day11/example.txt"))
        )
    }

    @Test fun `Part 2 Solution`(){
        assertEquals(
            0L,
            Day11().part2(File("src/test/resources/day11/input.txt"))
        )
    }
}

