package com.github.luketrenaman.aoc2025

import java.io.File

class Day8 {
    data class WeightedEdge(val edge: Pair<Int, Int>, val weight: Double)
    fun part1(input: File): Long {
        fun sqd(x: Double,y: Double) = (x-y) * (x-y)
        fun dist(coord1: List<Int>, coord2: List<Int>): Double =
            coord1.zip(coord2).sumOf { sqd(it.first.toDouble(), it.second.toDouble()) }

        val coords = input.readLines().map{ line -> line.split(",").map{it.toInt()}}
        val edges = mutableListOf<WeightedEdge>()
        for(i in coords.indices){
            for(j in (coords.indices - i)){
                if(coords[i] != coords[j]){
                    edges.add(WeightedEdge(i to j, dist(coords[i], coords[j])))
                }
            }
        }
        edges.sortBy{
            it.weight
        }
        var edgesToAdd = 10
        val adj = mutableMapOf<Int, MutableList<Int>>()
        while(edgesToAdd > 0){
            val edge = edges.removeAt(0).edge
            if(!adj.contains(edge.first)) adj[edge.first] = mutableListOf()
            if(!adj.contains(edge.second)) adj[edge.second] = mutableListOf()
            adj[edge.first]!!.add(edge.second)
            adj[edge.second]!!.add(edge.first)
            edgesToAdd--
        }
    }
    fun part2(input: File): Long {
        return -1
    }
}

