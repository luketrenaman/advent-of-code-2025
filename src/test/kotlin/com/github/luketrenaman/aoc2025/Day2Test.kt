package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File
import kotlin.math.log10

class Day2Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            1227775554,
            Day2().part1(File("src/test/resources/day2/example.txt"))
        )
    }
    @Test fun `Part 1 Solution`(){
        assertEquals(
            34826702005,
            Day2().part1(File("src/test/resources/day2/input.txt"))
        )
    }
    @Test fun `Part 2 Example`(){
        assertEquals(
            4174379265UL,
            Day2().part2(File("src/test/resources/day2/example.txt"))
        )
    }
    @Test fun `Part 2 Solution`(){
        assertEquals(
            43287141963UL,
            Day2().part2(File("src/test/resources/day2/input.txt"))
        )
    }
}

