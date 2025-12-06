package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class Day1Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            Day1().part1(File("src/test/resources/day1/example.txt")),
            3
        )
    }
    @Test fun `Part 1 Solution`(){
        assertEquals(
            Day1().part1(File("src/test/resources/day1/input.txt")),
            1066
        )
    }
    @Test fun `Part 2 Example`(){
        assertEquals(
            Day1().part2(File("src/test/resources/day1/example.txt")),
            6
        )
    }
    @Test fun `Part 2 Solution`(){
        assertEquals(
            Day1().part2(File("src/test/resources/day1/input.txt")),
            6223
        )
    }
    @Test fun `Part 2 Optimized Example`(){
        assertEquals(
            6,
            Day1().part2Optimized(File("src/test/resources/day1/example.txt"))
        )
    }
    @Test fun `Part 2 Optimized Solution`(){
        assertEquals(
            6223,
            Day1().part2Optimized(File("src/test/resources/day1/input.txt"))
        )
    }
}