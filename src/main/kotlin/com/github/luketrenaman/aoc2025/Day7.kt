package com.github.luketrenaman.aoc2025

import java.io.File
import java.util.LinkedList
import java.util.Queue

class Day7 {
    fun part1(input: File): Int {
        val grid = input.readLines()
        val rows = grid.size
        val cols = grid[0].length
        fun safeBoundsCheck(i: Int, j: Int) = !(i < 0 || j < 0 || i >= rows || j >= cols)
        var next = LinkedList<Pair<Int, Int>>()
        val counts = mutableMapOf<Pair<Int,Int>, Int>()
        for(row in grid.indices){
            for(col in grid[0].indices){
                if(grid[row][col] == 'S'){
                    next.push(Pair(row, col))
                    counts[Pair(row, col)] = 1
                }
            }
        }
        fun inc(key: Pair<Int, Int>, by: Int) {
            if (counts.contains(key)) {
                counts[key] = counts[key]!! + by
            } else {
                counts[key] = by
                next.push(key)
            }
        }
        var splits = 0
        while(next.isNotEmpty()){
            val loc = next.pop()
            val currentCount = counts[loc]!!
            val down = Pair(loc.first+1, loc.second)
            if(!safeBoundsCheck(down.first, down.second)){
                continue
            }
            if(grid[down.first][down.second] == '^'){
                inc(Pair(down.first, down.second-1), currentCount)
                inc(Pair(down.first, down.second+1), currentCount)
                splits += currentCount
            } else{
                inc(down, currentCount)
            }
        }
        return splits
    }
    fun part2(input: File): Long {
        val grid = input.readLines()
        val rows = grid.size
        val cols = grid[0].length
        fun safeBoundsCheck(i: Int, j: Int) = !(i < 0 || j < 0 || i >= rows || j >= cols)
        var next: Queue<Pair<Int, Int>> = LinkedList()
        val counts = mutableMapOf<Pair<Int,Int>, Long>()
        for(row in grid.indices){
            for(col in grid[0].indices){
                if(grid[row][col] == 'S'){
                    next.add(Pair(row, col))
                    counts[Pair(row, col)] = 1
                }
            }
        }
        fun inc(key: Pair<Int, Int>, by: Long) {
            if (counts.contains(key)) {
                counts[key] = counts[key]!! + by
            } else {
                counts[key] = by
                next.add(key)
            }
        }
        var splits = 0L

        while(next.isNotEmpty()){
            val loc = next.remove()
            val currentCount = counts[loc]!!
            val down = Pair(loc.first+1, loc.second)
            if(down.first == rows){
                splits += currentCount
            }
            if(!safeBoundsCheck(down.first, down.second)){
                continue
            }
            if(grid[down.first][down.second] == '^'){
                inc(Pair(down.first, down.second-1), currentCount)
                inc(Pair(down.first, down.second+1), currentCount)
            } else{
                inc(down, currentCount)
            }
        }
//        val debugCounts = Array(rows) {Array(cols) {0} }
//        counts.forEach{
//            pair -> debugCounts[pair.key.first][pair.key.second] = pair.value
//        }
//        debugCounts.forEach {
//            it.forEach { print("$it") }
//            println()
//        }
        return splits
    }
}