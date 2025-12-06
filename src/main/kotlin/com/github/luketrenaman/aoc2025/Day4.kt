package com.github.luketrenaman.aoc2025

import java.io.File

class Day4 {
    fun part1(input: File): Int {
        var grid = input.readLines().map{x -> x.split("").toMutableList()}
        val rows = grid.size
        val cols = grid[0].size

        fun checkNeighborPaper(i: Int, j: Int): Int{
            if(i < 0 || j < 0 || i >= rows || j >= cols) return 0
            if(grid[i][j] == "@") return 1
            return 0
        }

        fun checkAllNeighborPaper(i: Int, j: Int): Int{
            var total = 0
            for(k in -1..1){
                for(m in -1..1){
                    if(!(k == 0 && m == 0)){
                        total += checkNeighborPaper(i + k, j + m)
                    }
                }
            }
            return total
        }

        var rolls = 0


        for(i in 0 until rows){
            for(j in 0 until cols){
                if(checkAllNeighborPaper(i, j) < 4 && grid[i][j] == "@"){
                    rolls++
                }
            }
        }

        return rolls
    }
    fun part2(input: File): Int {
        val grid = input.readLines().map{x -> x.split("").toMutableList()}
        val rows = grid.size
        val cols = grid[0].size

        fun checkNeighborPaper(i: Int, j: Int): Int{
            if(i < 0 || j < 0 || i >= rows || j >= cols) return 0
            if(grid[i][j] == "@") return 1
            return 0
        }

        fun checkAllNeighborPaper(i: Int, j: Int): Int{
            var total = 0
            for(k in -1..1){
                for(m in -1..1){
                    if(!(k == 0 && m == 0)){
                        total += checkNeighborPaper(i + k, j + m)
                    }
                }
            }
            return total
        }

        var rolls = 0

        var removed: Int
        do {
            removed = 0
            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    if (checkAllNeighborPaper(i, j) < 4 && grid[i][j] == "@") {
                        grid[i][j] = ".";
                        removed++
                    }
                }
            }
            rolls += removed
        } while(removed > 0)
        return rolls
    }
    fun part2Optimized(input: File): Int {
        // Create an edge out of every @
        // Create a grid where each cell's value is its number of neighbors
        // Then, create a priority queue weighted on value and using (i,j) as a unique identifier
        val grid = input.readLines().map{x -> x.split("").toMutableList()}
        val offsets = (-1..1).flatMap { x ->
            (-1..1).map { y -> x to y }
        }.filterNot { it == 0 to 0 }
        val rows = grid.size
        val cols = grid[0].size

        fun safeBoundsCheck(i: Int, j: Int) = !(i < 0 || j < 0 || i >= rows || j >= cols)
        fun checkNeighborPaper(i: Int, j: Int) = if(safeBoundsCheck(i,j) && grid[i][j] == "@") 1 else 0

        fun checkAllNeighborPaper(i: Int, j: Int) =
            offsets.sumOf{ (k,m) -> checkNeighborPaper(i + k, j + m)}
        val counts = Array(rows) {Array(cols) {0} }
        val remainingPaper = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if(grid[i][j] == "@") {
                    counts[i][j] = checkAllNeighborPaper(i, j)
                    remainingPaper.add(Pair(i, j))
                }
            }
        }
        var rolls = 0
        val pairsToRemove = mutableSetOf<Pair<Int,Int>>()
        do{
            pairsToRemove.clear()
            for(pair in remainingPaper){
                val (i,j) = pair
                // If the count is less than 4, remove the roll and update all adjacent cells
                if(counts[i][j] < 4){
                    pairsToRemove.add(pair)
                }
            }
            pairsToRemove.forEach{
                (i,j) ->
                offsets.forEach { (k, m) ->
                    val i2 = i + k
                    val j2 = j + m
                    if (safeBoundsCheck(i2, j2)) {
                        counts[i2][j2]--
                    }
                }
            }
            remainingPaper.removeAll(pairsToRemove)
            rolls += pairsToRemove.size
        } while(pairsToRemove.isNotEmpty())
        return rolls
    }
}

