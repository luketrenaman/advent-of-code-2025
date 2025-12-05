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
}