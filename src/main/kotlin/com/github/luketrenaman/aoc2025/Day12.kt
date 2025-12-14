package com.github.luketrenaman.aoc2025

import java.io.File

class Day12 {
    fun String.toIntArray(): IntArray = this.map{if(it == '#') 1 else 0}.toIntArray()
    data class Grid(val width: Int, val height: Int, val shapeCounts: List<Int>)
    fun part1(input: File): Long {
        // There are two filters that can be applied to determine the result of hopefully a lot of these cases
        // "does the bounding box of each input fit inside of the provided grid" this is always 3x3 and is a SUCCESS result
        // "does the total number of cells for each input we're using exceed the size of the grid" and is a FAIL result
        // Then we will be left with the "hard" problems

        // Ok let's use our assumption: all shapes are 3x3 and there is exactly 5 shapes
        val width = 3
        val height = 3
        val numShapes = 6
        val inputHeight = 5 // This includes empty space
        // We can parse at lines skip i, i+1, i+2, i+3, skip i+4
        val lines = input.readLines()
        val shapes = mutableListOf(Array(height) { IntArray(width) })
        val counts = mutableListOf<Int>()
        for(i in 0 until numShapes){
            val shape = Array(height) { IntArray(width) }
            var count = 0
            for(j in 0 until height){
                shape[j] = lines[i * inputHeight + j + 1].toIntArray()
                count += shape[j].sum()
            }
            shapes.add(shape)
            counts.add(count)
        }
        // Then read all grid inputs until EOF using an explicit line number
        val endLoc = inputHeight * numShapes
        val uncheckedGrids = lines.subList(endLoc, lines.size).map{ line ->
            val parts = line.split(": ")
            val dims = parts[0].split("x").map{it.toInt()}
            val indices = parts[1].split(" ").map{it.toInt()}
            Grid(dims[0], dims[1], indices)
        }.toMutableList()
        val safeGrids = uncheckedGrids.filter{
            val numSquares = (it.height / 3) * (it.width / 3)
            // If there are enough bounding squares for each shape
            numSquares >= it.shapeCounts.sum()
        }
        uncheckedGrids.removeAll(safeGrids)
        val unsafeGrids = uncheckedGrids.filter{
            val totalSize = it.width * it.width
            val totalSizeUsed = it.shapeCounts
                .mapIndexed { idx, amount -> counts[idx] * amount }
                .sum()
            totalSizeUsed > totalSize
        }
        uncheckedGrids.removeAll(unsafeGrids)

        println("Unchecked grid count ${uncheckedGrids.size}")
        println("Safe grid count ${safeGrids.size}")
        println("Unsafe grid count ${unsafeGrids.size}")

        return safeGrids.size.toLong()
    }
}

