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
}

