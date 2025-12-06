package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day8Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            0L,
            Day8().part1(File("src/test/resources/day8/example.txt"))
        )
    }

    @Test fun `Part 1 Solution`(){
        assertEquals(
            0L,
            Day8().part1(File("src/test/resources/day8/input.txt"))
        )
    }

    @Test fun `Part 2 Example`(){
        assertEquals(
            0L,
            Day8().part2(File("src/test/resources/day8/example.txt"))
        )
    }

    @Test fun `Part 2 Solution`(){
        assertEquals(
            0L,
            Day8().part2(File("src/test/resources/day8/input.txt"))
        )
    }
}

