package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class Day4Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            13,
            Day4().part1(File("src/test/resources/day4/example.txt"))
        )
    }
    @Test fun `Part 1 Solution`(){
        assertEquals(
            1537,
            Day4().part1(File("src/test/resources/day4/input.txt"))
        )
    }
    @Test fun `Part 2 Example`(){
        assertEquals(
            43,
            Day4().part2(File("src/test/resources/day4/example.txt"))
        )
    }
    @Test fun `Part 2 Solution`(){
        assertEquals(
            8707,
            Day4().part2(File("src/test/resources/day4/input.txt"))
        )
    }
}

