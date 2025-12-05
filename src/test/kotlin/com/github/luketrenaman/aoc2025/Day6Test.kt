package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day6Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            0,
            Day6().part1(File("src/test/resources/day6/example.txt"))
        )
    }

    @Test fun `Part 1 Solution`(){
        assertEquals(
            0,
            Day6().part1(File("src/test/resources/day6/input.txt"))
        )
    }

    @Test fun `Part 2 Example`(){
        assertEquals(
            0,
            Day6().part2(File("src/test/resources/day6/example.txt"))
        )
    }

    @Test fun `Part 2 Solution`(){
        assertEquals(
            0,
            Day6().part2(File("src/test/resources/day6/input.txt"))
        )
    }
}