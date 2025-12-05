package com.github.luketrenaman.aoc2025

import java.io.File

class Day1 {
    fun part1(input: File): Int {
        var current = 50
        val max = 100
        var pwd = 0
        input.forEachLine { line ->
            val multiplier = if (line[0] == 'L') -1 else 1
            val diff = line.drop(1).toInt()
            current = (current + max + multiplier * diff) % max
            if (current == 0) pwd++
        }
        return pwd
    }
    fun part2(input: File): Int {
        var current = 50
        val max = 100
        var pwd = 0
        input.forEachLine { line ->
            val multiplier = if (line[0] == 'L') -1 else 1
            val diff = line.drop(1).toInt()
            for(i in 1..diff) {
                current = (current + max + multiplier) % max
                if (current == 0) pwd++
            }
        }
        return pwd
    }
}