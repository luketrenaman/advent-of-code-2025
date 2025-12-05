package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class Day3Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            357,
            Day3().part1(File("src/test/resources/day3/example.txt"))
        )
    }
    @Test fun `Part 1 Solution`(){
        assertEquals(
            16858,
            Day3().part1(File("src/test/resources/day3/input.txt"))
        )
    }
    @Test fun `Part 2 Example`(){
        assertEquals(
            3121910778619,
            Day3().part2(File("src/test/resources/day3/example.txt"))
        )
    }
    @Test fun `Part 2 Solution`(){
        assertEquals(
            167549941654721,
            Day3().part2(File("src/test/resources/day3/input.txt"))
        )
    }
}

