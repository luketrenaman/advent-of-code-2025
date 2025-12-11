package com.github.luketrenaman.aoc2025

import java.io.File
import java.util.LinkedList
import java.util.Queue
import kotlin.collections.contains

class Day11 {
    fun performTraversal(start: String, end: String, adj: Map<String, List<String>>): Long{
        var next: Queue<String> = LinkedList()
        val counts = mutableMapOf<String, Long>()
        fun inc(key: String, by: Long) {
            if (counts.contains(key)) {
                counts[key] = counts[key]!! + by
            } else {
                counts[key] = by
                next.add(key)
            }
        }
        next.add(start)
        counts[start] = 1
        while(next.isNotEmpty()){
            val loc = next.remove()
            val currentCount = counts[loc]!!
            if(adj.contains(loc)) {
                for (child in adj[loc]!!) {
                    inc(child, currentCount)
                }
            }
            println(loc)
            println(counts)
        }
        println("${start} -> ${end}")
        println(counts)
        if(counts.contains(end)) return counts[end]!!
        return 0
    }


    fun part1(input: File): Long {
        val grid = input.readLines()
        val adj = grid.map { it.split(":") }.associate { it[0] to it[1].trim().split(" ") }
        return performTraversal("you", "out", adj)
    }
    fun part2(input: File): Long {
        val grid = input.readLines()
        val adj = grid.map { it.split(":") }.associate { it[0] to it[1].trim().split(" ") }

        println(performTraversal("svr", "out", adj))
        // 105046295149136 total
        // 4913080290762 smaller amt
        // Note that there is no backtracking, graph is directed
//        println(performTraversal("fft", "svr", adj))
//        println(performTraversal("dac", "svr", adj))

        // testing svr -> fft -> dac -> out
        // testing svr -> dac -> fft -> out
        /*
         * becauase the graph is directed we must either visit fft first or dac first
         * it would then be followed by the corresponding item in the pair
         * then, we reach the output
         * so we are computing the unique ways to reach each relevant point, then multioplying together
         */
        //println(adj)

        println("----------")

        performTraversal("svr", "fft", adj)
        performTraversal("svr", "dac", adj)
        performTraversal("svr", "out", adj)

        performTraversal("dac", "svr", adj)
        performTraversal("dac", "fft", adj)
        performTraversal("dac", "out", adj)

        performTraversal("fft", "svr", adj)
        performTraversal("fft", "dac", adj)
        performTraversal("fft", "out", adj)

        performTraversal("out", "svr", adj)
        performTraversal("out", "fft", adj)
        performTraversal("out", "dac", adj)

        println("----------")

        // 1289 * 842889 * 4522
        // 11298554268  * 0 * 7637246696
        println(adj)
        return(
                performTraversal("svr", "fft", adj)
                * performTraversal("fft", "dac", adj)
                * performTraversal("dac", "out", adj)
                + performTraversal("svr", "dac", adj)
                * performTraversal("dac", "fft", adj)
                * performTraversal("fft", "out", adj))

    }
}

