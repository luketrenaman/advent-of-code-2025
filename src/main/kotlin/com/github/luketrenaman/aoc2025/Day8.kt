package com.github.luketrenaman.aoc2025

import java.io.File
import kotlin.math.sqrt

class Day8 {
    data class WeightedEdge(val edge: Pair<Int, Int>, val weight: Double)
    fun sqd(x: Double,y: Double) = (x-y) * (x-y)
    fun dist(coord1: List<Int>, coord2: List<Int>): Double =
        sqrt(coord1.zip(coord2).sumOf { sqd(it.first.toDouble(), it.second.toDouble()) })
    fun part1(input: File): Long {
        val coords = input.readLines().map{ line -> line.split(",").map{it.toInt()}}
        val edges = mutableListOf<WeightedEdge>()
        for(i in coords.indices){
            for(j in (i+1)until(coords.size)){
                edges.add(WeightedEdge(i to j, dist(coords[i], coords[j])))
            }
        }
        edges.sortBy{ it.weight }
        var edgesToAdd = if(coords.size == 1000) 1000 else 10
        val trees = coords.indices.map{mutableSetOf(it)}.toMutableList()
        while(edgesToAdd > 0){
            val edge = edges.removeAt(0).edge
            val s1 = trees.find{edge.first in it}
            val s2 = trees.find{edge.second in it}
            if(s1 != s2){
                s1!!.addAll(s2!!)
                trees.remove(s2)
            }
            edgesToAdd--
        }
        //println(trees)
        return trees.map{it.size.toLong()}.sortedDescending().take(3).reduce(Long::times)
    }
    fun part2(input: File): Long {
        val coords = input.readLines().map{ line -> line.split(",").map{it.toInt()}}
        val edges = mutableListOf<WeightedEdge>()
        for(i in coords.indices){
            for(j in (i+1)until(coords.size)){
                if(coords[i] != coords[j]){
                    edges.add(WeightedEdge(i to j, dist(coords[i], coords[j])))
                }
            }
        }
        edges.sortBy{ it.weight }
        val trees = coords.indices.map{mutableSetOf(it)}.toMutableList()
        var edge: Pair<Int, Int> = edges[0].edge
        while(trees.size > 1){
            edge = edges.removeAt(0).edge
            val s1 = trees.find{edge.first in it}
            val s2 = trees.find{edge.second in it}
            if(s1 != s2){
                s1!!.addAll(s2!!)
                trees.remove(s2)
            }
        }
        return coords[edge.first][0].toLong() * coords[edge.second][0].toLong()
    }
}

