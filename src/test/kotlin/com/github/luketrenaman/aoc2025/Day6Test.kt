package com.github.luketrenaman.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day6Test {
    @Test fun `Part 1 Example`(){
        assertEquals(
            4277556L,
            Day6().part1(File("src/test/resources/day6/example.txt"))
        )
    }

    @Test fun `Part 1 Solution`(){
        assertEquals(
            5227286044585L,
            Day6().part1(File("src/test/resources/day6/input.txt"))
        )
    }

    @Test fun `Part 2 Example`(){
        assertEquals(
            3263827L,
            Day6().part2(File("src/test/resources/day6/example.txt"))
        )
    }

    @Test fun `Part 2 Solution`(){
        assertEquals(
            10227753257799L,
            Day6().part2(File("src/test/resources/day6/input.txt"))
        )
    }
}