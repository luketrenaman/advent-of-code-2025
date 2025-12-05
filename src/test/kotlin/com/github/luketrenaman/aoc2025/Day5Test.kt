package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class Day5Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            3,
            Day5().part1(File("src/test/resources/day5/example.txt"))
        )
    }
    @Test fun `Part 1 Solution`(){
        assertEquals(
            607,
            Day5().part1(File("src/test/resources/day5/input.txt"))
        )
    }
    @Test fun `Part 2 Example`(){
        assertEquals(
            14,
            Day5().part2(File("src/test/resources/day5/example.txt"))
        )
    }
    @Test fun `Part 2 Solution`(){
        assertEquals(
            342433357244012,
            Day5().part2(File("src/test/resources/day5/input.txt"))
        )
    }
}

