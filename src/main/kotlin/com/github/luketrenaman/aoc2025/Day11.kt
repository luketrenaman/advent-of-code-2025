package com.github.luketrenaman.aoc2025

import java.io.File
import java.util.*


class Day11 {
    fun performTraversalOld(start: String, end: String, adj: Map<String, List<String>>): Long{
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
        }
        if(counts.contains(end)) return counts[end]!!
        return 0
    }
    fun performTraversal(start: String, end: String, list: List<String>, adj: Map<String, List<String>>): Long{
        val counts = mutableMapOf<String, Long>()
        for(node in list){
            counts[node] = 0
        }
        fun inc(key: String, by: Long) {
            if (counts.contains(key)) {
                counts[key] = counts[key]!! + by
            } else {
                counts[key] = by
            }
        }
        counts[start] = 1
        for(loc in list.subList(list.indexOf(start), list.indexOf(end))){
            val currentCount = counts[loc]!!
            if(adj.contains(loc)) {
                for (child in adj[loc]!!) {
                    inc(child, currentCount)
                }
            }
        }
        if(counts.contains(end)) return counts[end]!!
        return 0
    }

    fun sortTopological(start: String, adj: Map<String, List<String>>): List<String>{
        val n: Int = adj.size
        val indegree = mutableMapOf<String, Int>()
        val q: Queue<String> = LinkedList()
        val result = ArrayList<String>()

        // Compute indegrees
        for (entry in adj) {
            if(indegree[entry.key] == null) indegree[entry.key] = 0
            for (next in entry.value) {
                //println("there is an edge from ${entry.key} to ${next} so increasing indegree of ${next} by 1")
                if(indegree[next] == null) indegree[next] = 0
                indegree[next] = indegree[next]!! + 1
            }
        }
//        println(adj)
//        println(indegree)

        q.add(start)

        // Kahn’s Algorithm (BFS)
        while (!q.isEmpty()) {
            val top = q.poll()!!
            result.add(top)
            val at = adj[top]
            if (at != null) {
                for (next in at) {
                    indegree[next] = indegree[next]!! - 1
                    if (indegree[next] == 0) {
                        q.add(next)
                    }
                }
            }
        }
        println("toplogical ${result}")
        return result
    }


    fun part1(input: File): Long {
        val grid = input.readLines()
        val adj = grid.map { it.split(":") }.associate { it[0] to it[1].trim().split(" ") }
        return performTraversalOld("you", "out",adj)
    }
    fun part2(input: File): Long {
        val grid = input.readLines()
        val adj = grid.map { it.split(":") }.associate { it[0] to it[1].trim().split(" ") }
        //println(performTraversal("svr", "out", adj))
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

//        println("----------")
//
//        performTraversal("svr", "fft", adj)
//        performTraversal("svr", "dac", adj)
//        performTraversal("svr", "out", adj)
//
//        performTraversal("dac", "svr", adj)
//        performTraversal("dac", "fft", adj)
//        performTraversal("dac", "out", adj)
//
//        performTraversal("fft", "svr", adj)
//        performTraversal("fft", "dac", adj)
//        performTraversal("fft", "out", adj)
//
//        performTraversal("out", "svr", adj)
//        performTraversal("out", "fft", adj)
//        performTraversal("out", "dac", adj)
//
//        println("----------")
        val topo = sortTopological("svr", adj)
        val dac = topo.indexOf("dac")
        val fft = topo.indexOf("fft")
        val out = topo.indexOf("out")
        if(fft < dac){
            return (
                performTraversal("svr", "fft", topo, adj)
                        * performTraversal("fft", "dac", topo, adj)
                        * performTraversal("dac", "out", topo, adj)
                )
        }
        return(
                performTraversal("svr", "dac", topo, adj)
                        * performTraversal("dac", "fft", topo, adj)
                        * performTraversal("fft", "out", topo, adj)
                )

    }
}

